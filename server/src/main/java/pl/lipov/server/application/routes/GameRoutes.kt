package pl.lipov.server.application.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.patch
import pl.lipov.server.application.dto.GameCompletedUpdateRequest
import pl.lipov.server.application.mapper.toResponse
import pl.lipov.server.domain.useCase.GameUseCases

fun Route.gameRoutes(
    useCases: GameUseCases
) {

    get("/games") {
        val games = useCases.getGames()
        call.respond(games.map { it.toResponse() })
    }

    patch("/games/{id}/completed") {
        val id = call.parameters["id"]
        if (id.isNullOrBlank()) {
            call.respond(HttpStatusCode.BadRequest, "Missing ID")
            return@patch
        }

        val request = call.receive<GameCompletedUpdateRequest>()
        useCases.updateGameCompletedStatus(id, request.completed)

        call.respond(HttpStatusCode.NoContent)
    }
}
