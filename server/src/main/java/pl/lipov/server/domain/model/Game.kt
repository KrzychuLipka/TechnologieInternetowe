package pl.lipov.server.domain.model

data class Game(
    val id: String,
    val title: String,
    val platform: Platform,
    val gameUrl: String,
    val completed: Boolean = false,
    val playable: Boolean = false
)
