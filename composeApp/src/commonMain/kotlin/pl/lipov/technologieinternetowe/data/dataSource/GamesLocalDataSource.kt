package pl.lipov.technologieinternetowe.data.dataSource

import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.model.Platform
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.franko
import technologieinternetowe.composeapp.generated.resources.star_craft
import technologieinternetowe.composeapp.generated.resources.medal_of_honor

object GamesLocalDataSource {// specjalny sposób definiowania klasy i jej jedynej instancji jednocześnie.

    val games: List<Game> = listOf(
        Game(
            id = "star_craft",
            title = "StarCraft",
            platforms = listOf(Platform.PC),
            imageRes = Res.drawable.star_craft
        ),
        Game(
            id = "franko",
            title = "Franko",
            platforms = listOf(Platform.PC, Platform.ANBERNIC),
            imageRes = Res.drawable.franko
        ),
        Game(
            id = "medal_of_honor",
            title = "Medal of Honor",
            platforms = listOf(Platform.PC, Platform.ANBERNIC),
            gogUrl = "https://www.gog.com/pl/game/medal_of_honor_allied_assault_war_chest",
            imageRes = Res.drawable.medal_of_honor
        )
    )

    fun getGameById(
        id: String
    ): Game? = games.find { it.id == id }
}
