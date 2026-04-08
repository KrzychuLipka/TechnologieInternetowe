package pl.lipov.server.infrastructure.database

import org.jetbrains.exposed.v1.core.Table
import pl.lipov.server.domain.model.Platform

object GamesTable : Table() {

    val id = varchar("id", 255)
    val title = varchar("title", 255)
    val platform = enumerationByName("platform", 50, Platform::class)
    val completed = bool("completed").default(false)
    val playable = bool("playable").default(false)

    override val primaryKey = PrimaryKey(id)
}