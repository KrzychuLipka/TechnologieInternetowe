package pl.lipov.technologieinternetowe.data.dataSource

import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.model.Platform

object GamesRepository {

    val games = listOf(
        Game(
            id = "duke_nukem",
            title = "Duke Nukem Collection",
            gameUrl = "https://evercade.co.uk/cartridges/duke-nukem-collection-1/",
            platform = Platform.EVERCADE
        ),

        Game(
            id = "tomb_raider",
            title = "Tomb Raider I-III Remastered Starring Lara Croft",
            gameUrl = "https://www.gog.com/pl/game/tomb_raider_i_to_iii_remastered"
        ),

        Game(
            id = "rayman",
            title = "Rayman Bundle",
            gameUrl = "https://www.gog.com/pl/game/rayman_bundle"
        )
    )
}
