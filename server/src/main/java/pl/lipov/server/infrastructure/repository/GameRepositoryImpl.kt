package pl.lipov.server.infrastructure.repository

import pl.lipov.server.domain.model.Game
import pl.lipov.server.domain.repository.GameRepository

class GameRepositoryImpl : GameRepository {

    override fun getAll(): List<Game> = emptyList()

    override fun updateGameCompletedStatus(
        id: String,
        completed: Boolean
    ): Boolean = true
}
