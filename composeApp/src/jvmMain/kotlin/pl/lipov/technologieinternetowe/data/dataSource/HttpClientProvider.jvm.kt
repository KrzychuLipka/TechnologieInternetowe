package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging

actual fun provideEngine(): HttpClientEngineFactory<*> = OkHttp

actual fun HttpClientConfig<*>.platformConfig() {
    install(Logging) {
        level = LogLevel.INFO
    }
}
