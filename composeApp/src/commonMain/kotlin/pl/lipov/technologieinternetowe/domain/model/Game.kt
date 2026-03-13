package pl.lipov.technologieinternetowe.domain.model

data class Game(
    val id: String,
    val title: String,
    val gogUrl: String,
    val magazineNumber: Int,
    val lastPlayed: Int? = null,
    val completed: Boolean = false,
    val additionalGames: List<String> = emptyList()
)
