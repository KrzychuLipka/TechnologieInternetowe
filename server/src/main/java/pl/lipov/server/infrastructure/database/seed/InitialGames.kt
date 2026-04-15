package pl.lipov.server.infrastructure.database.seed

import pl.lipov.server.domain.model.Game
import pl.lipov.server.domain.model.Platform

val initialGames = listOf(
    Game(
        id = "mortal_kombat",
        title = "Mortal Kombat (1992)",
        gameUrl = "https://www.gog.com/pl/game/mortal_kombat_123",
        platform = Platform.GOG,
        playable = true
    ),
    Game(
        id = "beneath_a_steel_sky",
        title = "Beneath a Steel Sky (1994)",
        gameUrl = "https://www.gog.com/pl/game/beneath_a_steel_sky",
        completed = true,
        platform = Platform.GOG,
        playable = true
    ),
    Game(
        id = "rayman",
        title = "Rayman (1995)",
        gameUrl = "https://www.gog.com/pl/game/rayman_forever",
        completed = true,
        platform = Platform.GOG,
        playable = true
    ),
    Game(
        id = "quake_the_offering",
        title = "Quake (1996)",
        gameUrl = "https://www.gog.com/pl/game/quake_the_offering",
        platform = Platform.GOG,
        playable = true
    ),
    Game(
        id = "tomb_raider",
        title = "Tomb Raider (1996)",
        gameUrl = "https://www.gog.com/pl/game/tomb_raider_i_to_iii_remastered",
        completed = true,
        platform = Platform.GOG,
        playable = true
    ),
    Game(
        id = "sensible_world_of_soccer_9697",
        title = "Sensible World of Soccer 96/97 (1996)",
        gameUrl = "https://www.gog.com/pl/game/sensible_world_of_soccer_9697",
        platform = Platform.GOG,
        playable = true
    ),
    Game(
        id = "moto_racer",
        title = "Moto Racer (1997)",
        gameUrl = "https://www.gog.com/pl/game/moto_racer",
        completed = true,
        platform = Platform.GOG,
        playable = true
    ),
    Game(
        id = "metal_slug_x",
        title = "Metal Slug X (1999)",
        gameUrl = "https://www.gog.com/pl/game/metal_slug_x",
        platform = Platform.GOG,
        playable = true,
        completed = true
    ),
    Game(
        id = "dino_crisis_2",
        title = "Dino Crisis 2 (2000)",
        gameUrl = "https://www.gog.com/pl/game/dino_crisis_2",
        platform = Platform.GOG,
        playable = true,
        completed = true
    ),
    Game(
        id = "streets_of_rage_4",
        title = "Streets of Rage 4 (2020)",
        gameUrl = "https://www.gog.com/pl/game/streets_of_rage_4",
        platform = Platform.GOG,
        playable = true
    )
)
