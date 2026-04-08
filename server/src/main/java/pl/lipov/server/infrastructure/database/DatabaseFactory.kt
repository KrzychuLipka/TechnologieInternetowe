package pl.lipov.server.infrastructure.database

import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import pl.lipov.server.infrastructure.database.seed.initialGames

object DatabaseFactory {

    private const val DB_CONNECTION_URL = "jdbc:sqlite:games.db"
    private const val DB_DRIVER = "org.sqlite.JDBC"

    fun init() {
        Database.connect(DB_CONNECTION_URL, driver = DB_DRIVER)
        transaction {
            SchemaUtils.create(GamesTable)

            if (GamesTable.selectAll().count() == 0L) {
                initialGames.forEach { game ->
                    GamesTable.insert {
                        it[id] = game.id
                        it[title] = game.title
                        it[platform] = game.platform
                        it[playable] = game.playable
                        it[completed] = game.completed
                    }
                }
            }
        }
    }
}
