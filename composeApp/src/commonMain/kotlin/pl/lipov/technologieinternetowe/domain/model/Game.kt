package pl.lipov.technologieinternetowe.domain.model

data class Game(
    val id: String,
    val title: String,
    val magazineNumber: Int = 9,
    val platform: Platform,
    val gameUrl: String? = null,
    val lastPlayed: Int? = null,
    val completed: Boolean = false,
    val playable: Boolean = false
)
