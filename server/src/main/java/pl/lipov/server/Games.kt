package pl.lipov.server

import org.jetbrains.exposed.v1.core.Table

object Games : Table() {

    val id = varchar("id", 255)
    val title = varchar("title", 255)
    val platform = enumerationByName("platform", 50, Platform::class)
    val gameUrl = varchar("gameUrl", 255).nullable()
    val completed = bool("completed").default(false)
    val playable = bool("playable").default(false)

    override val primaryKey = PrimaryKey(id)
}
