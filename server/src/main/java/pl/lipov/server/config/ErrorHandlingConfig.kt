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

        exception<Throwable> { call, cause ->
            call.respond(
                HttpStatusCode.InternalServerError,
                ErrorResponse("INTERNAL_ERROR", cause.message ?: "Unknown error")
            )
        }

        exception<NotFoundException> { call, cause ->
            call.respond(
                HttpStatusCode.NotFound,
                ErrorResponse("NOT_FOUND", cause.message ?: "Resource not found")
            )
        }

        exception<BadRequestException> { call, cause ->
            call.respond(
                HttpStatusCode.BadRequest,
                ErrorResponse("BAD_REQUEST", cause.message ?: "Invalid request")
            )
        }

        exception<ValidationException> { call, cause ->
            call.respond(
                HttpStatusCode.UnprocessableEntity,
                ErrorResponse("VALIDATION_ERROR", cause.message ?: "Validation failed")
            )
        }
    }
}
