package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

actual object HttpClientProvider {
    actual val httpClient = HttpClient(Js) {
        install(ContentNegotiation) {
            json()
        }
    }
}
