package pl.lipov.technologieinternetowe.domain.model

data class Game(
    val id: String,
    val title: String,
    val gogUrl: String,
    val completed: Boolean = false
) {

    fun markAsCompleted(): Game = copy(completed = true)

    fun markAsUncompleted(): Game = copy(completed = false)
}
