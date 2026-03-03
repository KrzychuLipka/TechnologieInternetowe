package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientProvider {

    const val HOST = "192.168.0.61"
    const val PORT = 8080

    val httpClient = HttpClient {

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }

        install(DefaultRequest) {
            url {
                protocol = URLProtocol.HTTP
                host = HOST
                port = PORT
            }
        }
    }
}
