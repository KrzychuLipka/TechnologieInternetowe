package pl.lipov.server.domain.error

class ValidationException(
    message: String
) : RuntimeException(message)