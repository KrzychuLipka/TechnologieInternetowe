package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual object HttpClientProvider {

    private const val HOST = "192.168.0.61"
    private const val PORT = 8080

    actual val httpClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        install(Logging) {
            level = LogLevel.INFO
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
