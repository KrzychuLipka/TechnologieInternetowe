package pl.lipov.technologieinternetowe.domain.model

data class Game(
    val id: String,
    val title: String,
    val platform: Platform = Platform.GOG,
    val gameUrl: String? = null,
    val completed: Boolean = false
)
