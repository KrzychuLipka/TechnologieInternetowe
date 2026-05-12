package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp

actual fun provideEngine(): HttpClientEngineFactory<*> = OkHttp

actual fun HttpClientConfig<*>.platformConfig() {
}
