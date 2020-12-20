import io.ktor.http.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

import kotlinx.browser.window

val endpoint = window.location.origin

val jsonClient = HttpClient {
    install(JsonFeature) { serializer = KotlinxSerializer() }
}

suspend fun getLinks(): List<ShortLinkDetails> {
    return jsonClient.get(endpoint + ShortLinkDetails.path)
}

suspend fun addShortLink(shortLinkDetails: ShortLinkDetails) {
    jsonClient.post<Unit>(endpoint + ShortLinkDetails.path) {
        contentType(ContentType.Application.Json)
        body = shortLinkDetails
    }
}

