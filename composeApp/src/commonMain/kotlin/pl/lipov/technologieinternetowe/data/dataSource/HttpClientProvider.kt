package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.HttpClient

expect object HttpClientProvider {
    val httpClient: HttpClient
}
