package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.HttpClient

const val HOST = "192.168.48.27"
const val PORT = 8080

expect object HttpClientProvider {

    val httpClient: HttpClient
}
