package pl.lipov.server

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import pl.lipov.server.config.configureCors
import pl.lipov.server.config.configureErrorHandling
import pl.lipov.server.config.configureRouting
import pl.lipov.server.config.configureSerialization

private const val PORT_NUMBER = 8080

fun main() {

    embeddedServer(Netty, port = PORT_NUMBER) {
        configureSerialization()
        configureCors()
        configureRouting()
        configureErrorHandling()
    }.start(wait = true)
}
