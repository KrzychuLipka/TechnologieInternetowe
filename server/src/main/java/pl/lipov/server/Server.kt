package pl.lipov.server

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import pl.lipov.server.config.configureCors
import pl.lipov.server.config.configureErrorHandling
import pl.lipov.server.config.configureRouting
import pl.lipov.server.config.configureSerialization
import pl.lipov.server.infrastructure.database.DatabaseFactory

private const val PORT_NUMBER = 8080

fun main() {

    embeddedServer(Netty, port = PORT_NUMBER) {
        DatabaseFactory.init()
        configureSerialization()
        configureCors()
        configureRouting()
        configureErrorHandling()
    }.start(wait = true)
}
