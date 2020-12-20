import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    val resource = object {}::class.java.classLoader.getResource("app.properties")
    System.getProperties().load(resource.openStream())
    Web3Client.get()
    val port = System.getProperty("PORT")?.toInt() ?: 8080
    embeddedServer(Netty, port) {
        install(ContentNegotiation) {
            json()
        }
        install(CORS) {
            method(HttpMethod.Get)
            method(HttpMethod.Post)
            method(HttpMethod.Delete)
            anyHost()
        }
        install(Compression) {
            gzip()
        }

        routing {
            get("/") {
                call.respondText(
                    this::class.java.classLoader.getResource("index.html")!!.readText(),
                    ContentType.Text.Html
                )
            }
            static("/") {
                resources("")
            }
            route(ShortLinkDetails.path) {
                get {
                    call.respond(Web3Client.getRecentLinks())
                }
                post {
                    val shortLink = call.receive<ShortLinkDetails>()
                    Web3Client.get().createShortLink(shortLink.url)
                    call.respond(HttpStatusCode.OK)
                }
                get("/l/{short}") {
                    val id = call.parameters["short"] ?: error("Invalid short link request")
                    Web3Client.get().getURLFromLabel(id)?.let { it1 -> call.respond(it1) }
                    call.respond(HttpStatusCode.OK)
                }
            }
        }
    }.start(wait = true)
}