package pl.lipov.server

import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.deleteWhere
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import org.jetbrains.exposed.v1.jdbc.update

fun main() {

    embeddedServer(Netty, port = 8080) {

        initDatabase()

        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }

        install(CORS) {
            anyHost()
            allowMethod(HttpMethod.Get)
            allowMethod(HttpMethod.Post)
            allowMethod(HttpMethod.Put)
            allowMethod(HttpMethod.Delete)
        }

        routing {

            get("/games") {
                val result = transaction {
                    Games.selectAll().map {
                        Game(
                            id = it[Games.id],
                            title = it[Games.title],
                            gameUrl = it[Games.gameUrl],
                            platform = it[Games.platform],
                            playable = it[Games.playable],
                            completed = it[Games.completed]
                        )
                    }
                }
                call.respond(result)
            }

            get("/games/{id}") {
                val id = call.parameters["id"]
                if (id.isNullOrBlank()) {
                    call.respond("Invalid ID")
                    return@get
                }

                val game = transaction {
                    Games
                        .selectAll()
                        .where { Games.id eq id }
                        .singleOrNull()
                        ?.let {
                            Game(
                                id = it[Games.id],
                                title = it[Games.title],
                                gameUrl = it[Games.gameUrl],
                                platform = it[Games.platform],
                                playable = it[Games.playable],
                                completed = it[Games.completed]
                            )
                        }
                }

                if (game == null) call.respond("Not found")
                else call.respond(game)
            }

            post("/games") {
                val newGame = call.receive<Game>()

                transaction {
                    Games.insert {
                        it[id] = newGame.id
                        it[title] = newGame.title
                        it[gameUrl] = newGame.gameUrl
                        it[platform] = newGame.platform
                        it[playable] = newGame.playable
                        it[completed] = newGame.completed
                    }
                }

                call.respond("Game added")
            }

            put("/games/{id}") {
                val id = call.parameters["id"]
                if (id.isNullOrBlank()) {
                    call.respond("Invalid ID")
                    return@put
                }

                val updated = call.receive<Game>()

                transaction {
                    Games.update({ Games.id eq id }) {
                        it[title] = updated.title
                        it[gameUrl] = updated.gameUrl
                        it[platform] = updated.platform
                        it[playable] = updated.playable
                        it[completed] = updated.completed
                    }
                }

                call.respond("Game updated")
            }

            delete("/games/{id}") {
                val id = call.parameters["id"]
                if (id.isNullOrBlank()) {
                    call.respond("Invalid ID")
                    return@delete
                }

                transaction {
                    Games.deleteWhere { Games.id eq id }
                }

                call.respond("Game deleted")
            }
        }

    }.start(wait = true)
}

private fun initDatabase() {
    Database.connect("jdbc:sqlite:games.db", driver = "org.sqlite.JDBC")

    transaction {
        SchemaUtils.create(Games)

        if (Games.selectAll().empty()) {

            GamesRepository.games.forEach { game ->
                Games.insert {
                    it[id] = game.id
                    it[title] = game.title
                    it[gameUrl] = game.gameUrl
                    it[platform] = game.platform
                    it[playable] = game.playable
                    it[completed] = game.completed
                }
            }
        }
    }
}
