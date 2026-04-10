package pl.lipov.server.infrastructure.database.seed

import pl.lipov.server.domain.model.Game
import pl.lipov.server.domain.model.Platform

val initialGames = listOf(

    Game(
        id = "flashback",
        title = "Flashback (1992)",
        gameUrl = "https://www.gog.com/pl/game/flashback",
        platform = Platform.GOG,
        playable = true
    ),

    Game(
        id = "beneath_a_steel_sky",
        title = "Beneath a Steel Sky (1994)",
        gameUrl = "https://www.gog.com/pl/game/beneath_a_steel_sky",
        platform = Platform.GOG
    ),

    Game(
        id = "rayman",
        title = "Rayman (1995)",
        gameUrl = "https://www.gog.com/pl/game/rayman_forever",
        platform = Platform.GOG,
        playable = true
    ),

    Game(
        id = "tomb_raider",
        title = "Tomb Raider (1996)",
        gameUrl = "https://www.gog.com/pl/game/tomb_raider_i_to_iii_remastered",
        platform = Platform.GOG,
        playable = true
    ),

    Game(
        id = "moto_racer",
        title = "Moto Racer (1997)",
        gameUrl = "https://www.gog.com/pl/game/moto_racer",
        platform = Platform.GOG,
        playable = true
    ),

    Game(
        id = "jazz_jackrabbit_2",
        title = "Jazz Jackrabbit 2 (1998)",
        gameUrl = "https://www.gog.com/pl/game/jazz_jackrabbit_2_collection",
        platform = Platform.GOG
    ),

    Game(
        id = "metal_slug_x",
        title = "Metal Slug X (1999)",
        gameUrl = "https://www.gog.com/pl/game/metal_slug_x",
        platform = Platform.GOG,
        playable = true
    ),

    Game(
        id = "dino_crisis_2",
        title = "Dino Crisis 2 (2000)",
        gameUrl = "https://www.gog.com/pl/game/dino_crisis_2",
        platform = Platform.GOG,
        playable = true
    ),

    Game(
        id = "red_faction",
        title = "Red Faction (2001)",
        gameUrl = "https://www.gog.com/pl/game/red_faction",
        platform = Platform.GOG
    ),

    Game(
        id = "medal_of_honor",
        title = "Medal of Honor: Allied Assault (2002)",
        gameUrl = "https://www.gog.com/pl/game/medal_of_honor_allied_assault_war_chest",
        platform = Platform.GOG,
        playable = true
    )
)
