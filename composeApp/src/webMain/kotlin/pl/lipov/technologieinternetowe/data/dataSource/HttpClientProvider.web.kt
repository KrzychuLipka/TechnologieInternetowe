package pl.lipov.technologieinternetowe.data.dataSource

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.js.Js

actual fun provideEngine(): HttpClientEngineFactory<*> = Js

actual fun HttpClientConfig<*>.platformConfig() {
}
