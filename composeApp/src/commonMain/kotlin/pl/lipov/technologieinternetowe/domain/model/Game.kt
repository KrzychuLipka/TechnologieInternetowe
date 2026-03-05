package pl.lipov.technologieinternetowe.domain.model

data class Game(
    val id: String,
    val title: String,
    val gameUrl: String? = null,
    val gogUrl: String? = null,
    val steamUrl: String? = null,
    val playable: Boolean = false
)
