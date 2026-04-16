package pl.lipov.server.config

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import pl.lipov.server.application.error.ErrorResponse
import pl.lipov.server.domain.error.NotFoundException
import pl.lipov.server.domain.error.ValidationException

fun Application.configureErrorHandling() {
    install(StatusPages) {

        exception<NotFoundException> { call, _ ->
            call.respond(
                HttpStatusCode.NotFound,
                ErrorResponse("GAME_NOT_FOUND")
            )
        }

        exception<BadRequestException> { call, _ ->
            call.respond(
                HttpStatusCode.BadRequest,
                ErrorResponse("BAD_REQUEST")
            )
        }

        exception<ValidationException> { call, _ ->
            call.respond(
                HttpStatusCode.UnprocessableEntity,
                ErrorResponse("VALIDATION_ERROR")
            )
        }

        exception<Throwable> { call, _ ->
            call.respond(
                HttpStatusCode.InternalServerError,
                ErrorResponse("INTERNAL_ERROR")
            )
        }
    }
}
