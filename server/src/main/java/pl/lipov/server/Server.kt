package pl.lipov.server

import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.http.content.staticFiles
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json
import pl.lipov.server.application.routes.gameRoutes
import pl.lipov.server.domain.useCase.GameUseCases
import pl.lipov.server.domain.useCase.GetGamesUseCase
import pl.lipov.server.domain.useCase.UpdateGameCompletedStatusUseCase
import pl.lipov.server.infrastructure.database.DatabaseFactory
import pl.lipov.server.infrastructure.repository.GameRepositoryImpl
import java.io.File

private const val IMAGES_REMOTE_PATH = "/images"

// TODO System.getenv("IMAGES_PATH") ?: "./images"
private const val IMAGES_LOCAL_DIR = "D:/roms/boxes"

fun main() {

    embeddedServer(Netty, port = 8080) {
        DatabaseFactory.init()
        configureSerialization()
        configureCors()
        configureRouting()
    }.start(wait = true)
}

private fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(
            Json {
                // TODO Remove in production
                prettyPrint = true
                ignoreUnknownKeys = true
                encodeDefaults = true
            }
        )
    }
}

private fun Application.configureCors() {
    // TODO Remove in production
    install(CORS) {
        anyHost()
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
    }
}

private fun Application.configureRouting() {
    val repository = GameRepositoryImpl()
    val useCases = GameUseCases(
        getGames = GetGamesUseCase(repository),
        updateGameCompletedStatus = UpdateGameCompletedStatusUseCase(repository)
    )
    routing {
        staticFiles(IMAGES_REMOTE_PATH, File(IMAGES_LOCAL_DIR))
        gameRoutes(useCases)
    }
}