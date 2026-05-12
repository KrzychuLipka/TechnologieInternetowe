package pl.lipov.server.domain.model

data class Game(
    val id: String,
    val title: String,
    val gameUrl: String,
    val platform: Platform = Platform.GOG,
    val completed: Boolean = false
)
