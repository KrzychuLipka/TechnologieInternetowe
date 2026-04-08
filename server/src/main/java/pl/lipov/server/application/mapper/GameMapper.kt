package pl.lipov.server.application.mapper

import org.jetbrains.exposed.v1.core.ResultRow
import pl.lipov.server.application.dto.GameResponse
import pl.lipov.server.domain.model.Game
import pl.lipov.server.infrastructure.database.GamesTable

fun ResultRow.toGame() = Game(
    id = this[GamesTable.id],
    title = this[GamesTable.title],
    platform = this[GamesTable.platform],
    playable = this[GamesTable.playable],
    completed = this[GamesTable.completed]
)

fun Game.toResponse() = GameResponse(
    id = this.id,
    title = this.title,
    platform = this.platform,
    playable = this.playable,
    completed = this.completed
)

