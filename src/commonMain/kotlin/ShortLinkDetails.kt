import kotlinx.serialization.Serializable

@Serializable
data class ShortLinkDetails(val label: String,
                            val url: String,
                            val owner: String,
                            val nodeId: String,
                            val blockNumber: Long) {
    companion object {
        const val path = "/links"
    }
}