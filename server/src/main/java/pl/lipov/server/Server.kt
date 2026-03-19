package pl.lipov.server

import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

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
            anyHost()// Only in dev mode
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
                            magazineNumber = it[Games.magazineNumber],
                            gameUrl = it[Games.gameUrl],
                            platform = it[Games.platform]
                        )
                    }
                }

                call.respond(result)
            }
        }
    }.start(wait = true)
}

private fun initDatabase() {
    Database.connect("jdbc:sqlite:games.db", driver = "org.sqlite.JDBC")

    transaction {
        SchemaUtils.create(Games)

        if (Games.selectAll().empty()) {
            Games.insert {
                it[id] = "streets_of_rage_4"
                it[title] = "Streets of Rage 4"
                it[magazineNumber] = 1
                it[gameUrl] = "https://www.gog.com/pl/game/streets_of_rage_4"
                it[platform] = Platform.GOG
                it[playable] = true
            }
            Games.insert {
                it[id] = "screamer"
                it[title] = "Screamer"
                it[magazineNumber] = 1
                it[gameUrl] = "https://www.gog.com/pl/game/screamer"
                it[platform] = Platform.GOG
                it[playable] = true
            }
            Games.insert {
                it[id] = "quake"
                it[title] = "Quake"
                it[magazineNumber] = 2
                it[gameUrl] = "https://www.gog.com/pl/game/quake_the_offering"
                it[platform] = Platform.GOG
            }
            Games.insert {
                it[id] = "medal_of_honor"
                it[title] = "Medal of Honor"
                it[magazineNumber] = 2
                it[gameUrl] = "https://www.gog.com/pl/game/medal_of_honor_allied_assault_war_chest"
                it[platform] = Platform.GOG
                it[playable] = true
                it[completed] = true
            }
            Games.insert {
                it[id] = "resident_evil"
                it[title] = "Resident Evil"
                it[magazineNumber] = 3
                it[gameUrl] = "https://www.gog.com/pl/game/resident_evil"
                it[platform] = Platform.GOG
                it[playable] = true
            }
            Games.insert {
                it[id] = "fear"
                it[title] = "F.E.A.R."
                it[magazineNumber] = 3
                it[gameUrl] = "https://www.gog.com/pl/game/fear_platinum"
                it[platform] = Platform.GOG
                it[playable] = true
            }
            Games.insert {
                it[id] = "psychonauts"
                it[title] = "Psychonauts"
                it[magazineNumber] = 4
                it[gameUrl] = "https://www.gog.com/pl/game/psychonauts"
                it[platform] = Platform.GOG
                it[playable] = true
            }
            Games.insert {
                it[id] = "rayman_origins"
                it[title] = "Rayman Origins"
                it[magazineNumber] = 4
                it[gameUrl] = "https://www.gog.com/pl/game/rayman_origins"
                it[platform] = Platform.GOG
                it[playable] = true
            }
            Games.insert {
                it[id] = "rune"
                it[title] = "Rune"
                it[magazineNumber] = 5
                it[gameUrl] = "https://www.gog.com/pl/game/rune_classic"
                it[platform] = Platform.GOG
                it[playable] = true
            }
            Games.insert {
                it[id] = "teenagent"
                it[title] = "Teenagent"
                it[magazineNumber] = 5
                it[gameUrl] = "https://www.gog.com/pl/game/teenagent"
                it[platform] = Platform.GOG
                it[completed] = true
                it[playable] = true
            }
        }
    }
}
