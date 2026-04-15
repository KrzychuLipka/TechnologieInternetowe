package pl.lipov.server.infrastructure.repository

import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import org.jetbrains.exposed.v1.jdbc.update
import pl.lipov.server.application.mapper.toGame
import pl.lipov.server.domain.model.Game
import pl.lipov.server.domain.repository.GameRepository
import pl.lipov.server.infrastructure.database.GamesTable

class GameRepositoryImpl : GameRepository {

    override fun getAll(): List<Game> = transaction {
        GamesTable.selectAll().map { it.toGame() }
    }

    override fun updateGameCompletedStatus(
        id: String,
        completed: Boolean
    ): Boolean = transaction {
        val updatedRows = GamesTable.update({ GamesTable.id eq id }) {
            it[GamesTable.completed] = completed
        }
        updatedRows > 0
    }
}
