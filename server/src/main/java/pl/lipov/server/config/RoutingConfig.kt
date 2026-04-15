package pl.lipov.server.config

import io.ktor.server.application.Application
import io.ktor.server.http.content.staticFiles
import io.ktor.server.routing.routing
import pl.lipov.server.application.routes.gameRoutes
import pl.lipov.server.domain.useCase.GameUseCases
import pl.lipov.server.domain.useCase.GetGamesUseCase
import pl.lipov.server.domain.useCase.UpdateGameCompletedStatusUseCase
import pl.lipov.server.infrastructure.repository.GameRepositoryImpl
import java.io.File

private const val IMAGES_REMOTE_PATH = "/images"

// TODO System.getenv("IMAGES_PATH") ?: "./images"
private const val IMAGES_LOCAL_DIR = "D:/roms/boxes"

fun Application.configureRouting() {
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
