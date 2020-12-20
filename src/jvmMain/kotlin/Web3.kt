import io.epirus.GanacheGasProvider
import io.epirus.generated.contracts.AKAP
import io.epirus.generated.contracts.URLShortener
import io.epirus.web3j.Epirus
import io.reactivex.Single
import org.slf4j.LoggerFactory
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.Network
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.http.HttpService
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.tx.gas.ContractGasProvider
import java.nio.file.Paths

object Web3Client {
    private val log = LoggerFactory.getILoggerFactory().getLogger("org.web3j.protocol.http.HttpService")

    private val deployNetwork: Network =
        Network.valueOf(System.getenv().getOrDefault("WEB3J_NETWORK", "rinkeby").toUpperCase())
    private val nodeUrl = System.getenv().getOrDefault("WEB3J_NODE_URL", "http://localhost:8545")
    private val environment = System.getProperty("ENVIRONMENT", "demo")

    private var init = false
    private lateinit var web3j: Web3j
    private lateinit var akapContract: AKAP
    private lateinit var urlShortenerContract: URLShortener
    private lateinit var credentials: Credentials
    private lateinit var gasProvider: ContractGasProvider

    fun get(): Web3Client {
        if (!init) {
            web3j = deployWeb3j()

            when(environment) {
                "development" -> {
                    val akapAddress = System.getProperty("AKAP_ADDRESS")
                    val urlShortenerAddress = System.getProperty("URL_SHORTENER_ADDRESS")
                    credentials = Credentials.create(System.getProperty("TEST_PRIVATE_KEY"))
                    gasProvider = GanacheGasProvider()
                    akapContract = AKAP.load(akapAddress, web3j, credentials, gasProvider)
                    urlShortenerContract = URLShortener.load(urlShortenerAddress, web3j, credentials, gasProvider)
                }
                "demo" -> {
                    val file = Paths.get(WalletUtils.
                    generateNewWalletFile("demo", Paths.get(".").toFile())).toFile()
                    credentials = WalletUtils.loadCredentials("demo", file)
                    gasProvider = GanacheGasProvider()
                    akapContract = AKAP.deploy(web3j, credentials, gasProvider).send()
                    urlShortenerContract = URLShortener.deploy(web3j,
                        credentials,
                        gasProvider,
                        akapContract.contractAddress,
                        "urlshortener".toByteArray(),
                        "").send()
                }
                else -> {
                    // TODO: Setup Epirus and officiaal networks
                }
            }
            init = true
        }
        return Web3Client
    }

    private fun randomAlphaNumeric(n: Int): String {
        val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return (0..n).map {
            chars.random()
        }.joinToString("")
    }

    private fun stringToBytes(str: String): ByteArray {
        val bytes = ByteArray(str.length)
        str.forEachIndexed { i, c ->
            bytes.set(i, c.toByte())
        }
        return bytes
    }

    fun createShortLink(longURL: String): String {
        val linkLabel = randomAlphaNumeric(7)
        val labelBytes = stringToBytes(linkLabel)
        val urlBytes = stringToBytes(longURL)
        val response = urlShortenerContract.claimAndSetNodeBody(labelBytes, urlBytes).send()
        log.debug("claimAndSetNodeBody tx $response.status ${response.transactionHash}")
        log.info("Created short link $linkLabel created for $longURL")
        return linkLabel
    }

    fun getURLFromLabel(label: String): String? {
        val labelBytes = stringToBytes(label)
        val parentNodeId = urlShortenerContract.parentNodeId().send()
        val nodeHash = akapContract.hashOf(parentNodeId, labelBytes).send()
        val data = akapContract.nodeBody(nodeHash).send()
        log.debug("getNodeFromLabel $parentNodeId $nodeHash")
        return String(data)
    }

    fun getRecentLinks(): MutableList<ShortLinkDetails> {
        log.debug("getRecentLinks: Retrieving Claim Events")
        val parentNodeId = urlShortenerContract.parentNodeId().send()
        val recentLinks = mutableListOf<ShortLinkDetails>()
        //TODO: applu proper Flowable approach to consume events
        akapContract.claimEventFlowable(DefaultBlockParameterName.EARLIEST,
            DefaultBlockParameterName.LATEST).filter{
             claimEventReponse -> parentNodeId == claimEventReponse.parentId
        }.forEach { claimEventReponse ->
            val blockNumber = claimEventReponse.log.blockNumber
            val nodeId =  claimEventReponse.nodeId
            val url = String(akapContract.nodeBody(nodeId).send())
            recentLinks.add(ShortLinkDetails(String(claimEventReponse.label),
                url,
                claimEventReponse.sender,
                nodeId.toString(),
                blockNumber.toLong()))
         }
        recentLinks.sortByDescending { it.blockNumber }
        return recentLinks
    }

    private fun deployWeb3j(): Web3j {
        return if (nodeUrl == null || nodeUrl.isEmpty()) {
            Epirus.buildWeb3j(deployNetwork)
        } else {
            log.info("Web3 connecting to $nodeUrl")
            Web3j.build(HttpService(nodeUrl))
        }
    }
}