package pl.lipov.technologieinternetowe.data.dataSource

import pl.lipov.technologieinternetowe.domain.model.Game

object GamesLocalDataSource {

    val games: List<Game> = listOf(
        Game(
            id = "star_craft",
            title = "StarCraft",
            gogUrl = "",
            steamUrl = "",
            gameUrl = ""
        ),
        Game(
            id = "franko",
            title = "Franko",
            gogUrl = "",
            steamUrl = "",
            gameUrl = ""
        )
    )
}
