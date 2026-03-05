package pl.lipov.server

import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.http.content.staticResources
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json
import pl.lipov.server.model.Game
import pl.lipov.server.model.RetroConfig
import java.io.File

private val baseDir = System.getProperty("user.dir")
private val romsDir = File("$baseDir/roms")

private val emulatorPaths = mapOf(
    "ps1Games" to "$baseDir/emulators/ps1/duckstation.exe",
    "snesGames" to "$baseDir/emulators/snes/snes9x.exe",
    "nesGames" to "$baseDir/emulators/nes/Mesen.exe",
    "megaDriveGames" to "$baseDir/emulators/megaDrive/Fusion.exe"
)

fun main() {
    embeddedServer(
        factory = Netty,
        port = SERVER_PORT,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }

    install(CORS) {
        anyHost()// Only in dev mode
        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.Authorization)
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
    }

    println("=== DEBUG ŚCIEŻEK ===")
    println("user.dir = ${System.getProperty("user.dir")}")
    println("baseDir = $baseDir")
    println("romsDir = $romsDir  (exists=${romsDir.exists()})")
    println("emulatorPaths = $emulatorPaths")
    println("======================")

    routing {

        get("/") {
            call.respondText("Hejo!")
        }

        get("/games/{retroNumber}") {
            val retroNumber = call.parameters["retroNumber"]?.toIntOrNull()
                ?: return@get call.respondText("Invalid retro number")

            val configStream = this::class.java.classLoader.getResourceAsStream("games.json")
                ?: return@get call.respondText("games.json not found")

            val config = Json.decodeFromString<RetroConfig>(configStream.reader().readText())

            val retroEntry = config.retro.firstOrNull { it.number == retroNumber }
                ?: return@get call.respond(emptyList<Game>())

            val games = retroEntry.games.map { entry ->
                Game(
                    id = entry.id,
                    title = entry.title,
                    gogUrl = entry.gogUrl,
                    steamUrl = entry.steamUrl,
                    gameUrl = buildGameUrl(entry.platform, entry.id),
                    playable = entry.playable
                )
            }

            call.respond(games)
        }

        post("/dosGames/{id}") {
            val id = call.parameters["id"] ?: return@post call.respondText("No game ID")

            val dosboxPath = "$baseDir/emulators/dos/DOSBox.exe"
            val gameDataPath = "$baseDir/roms/$id/DATA"

            runProcess(
                dosboxPath,
                "-noconsole",
                "-fullscreen",
                "-c", "mount C $gameDataPath",
                "-c", "C:",
                "-c", "$id.EXE",
                "-c", "exit"
            )

            call.respond(HttpStatusCode.OK)
        }

        post("/windowsGames/{id}") {
            val id = call.parameters["id"] ?: return@post call.respondText("No game ID")

            val exeFile = findFileByName(id, "exe")
                ?: return@post call.respondText("No installer found for game: $id")

            runProcess(exeFile.absolutePath)
            call.respond(HttpStatusCode.OK)
        }

        emulatorPaths.forEach { (route, emulatorPath) ->
            emulatorRoute(route, emulatorPath)
        }

        println("Classloader resources root: " + this::class.java.classLoader.getResource(""))
        println("Image exists? " + (this::class.java.classLoader.getResource("images/retro1.png") != null))
        staticResources("/images", "images")
    }
}

/* ================== HELPER FUNCTIONS ================== */

private fun Route.emulatorRoute(route: String, emulatorPath: String) {
    post("/$route/{id}") {
        val id = call.parameters["id"] ?: return@post call.respondText("No game ID")

        val romFile = findFileByName(id)
            ?: return@post call.respondText("No ROM found for game: $id")

        runProcess(emulatorPath, romFile.absolutePath)
        call.respond(HttpStatusCode.OK)
    }
}

private fun findFileByName(name: String, extension: String? = null): File? {
    return romsDir.listFiles()?.firstOrNull { file ->
        file.nameWithoutExtension.equals(name, ignoreCase = true) &&
                (extension == null || file.extension.equals(extension, ignoreCase = true))
    }
}

private fun runProcess(vararg command: String) {
    ProcessBuilder(*command).start()
}

private fun buildGameUrl(platform: String?, id: String): String? {
    return when (platform?.lowercase()) {
        "windows" -> "/windowsGames/$id"
        "dos" -> "/dosGames/$id"
        "snes" -> "/snesGames/$id"
        "nes" -> "/nesGames/$id"
        "megadrive" -> "/megaDriveGames/$id"
        "ps1" -> "/ps1Games/$id"
        else -> null
    }
}