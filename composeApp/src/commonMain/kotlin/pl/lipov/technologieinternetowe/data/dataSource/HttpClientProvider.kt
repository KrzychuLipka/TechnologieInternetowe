package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.HttpClient

const val HOST = "192.168.0.61"
const val PORT = 8080

expect object HttpClientProvider {

    val httpClient: HttpClient
}
