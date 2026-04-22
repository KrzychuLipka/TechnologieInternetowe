package pl.lipov.server.domain.model

data class Game(
    val id: String,
    val platform: Platform,
    val playable: Boolean = false
)
