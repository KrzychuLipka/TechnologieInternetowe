package pl.lipov.server.domain.repository

import pl.lipov.server.domain.model.Game

interface GameRepository {
    fun getAll(): List<Game>
    fun updateGameCompletedStatus(id: String, completed: Boolean)
}
