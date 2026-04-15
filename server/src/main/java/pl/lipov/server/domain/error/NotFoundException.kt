package pl.lipov.server.domain.error

class NotFoundException(
    message: String
) : RuntimeException(message)
