package pl.lipov.technologieinternetowe.data.dataSource

import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.model.Platform

object GamesRepository {

    val games = listOf(
        Game(
            "commander_keen_complete_pack",
            "Commander Keen (1990)",
            gameUrl = "https://www.gog.com/pl/game/commander_keen_complete_pack",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "flashback",
            "Flashback (1992)",
            gameUrl = "https://www.gog.com/pl/game/flashback",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "wolfenstein_3d",
            "Wolfenstein 3D (1992)",
            gameUrl = "https://www.gog.com/pl/game/wolfenstein_3d",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "indiana_jones_and_the_fate_of_atlantis",
            "Indiana Jones and the Fate of Atlantis (1992)",
            gameUrl = "https://www.gog.com/pl/game/indiana_jones_and_the_fate_of_atlantis",
            platform = Platform.GOG,
            completed = true
        ),

        Game(
            "mortal_kombat",
            "Mortal Kombat (1992)",
            gameUrl = "https://www.gog.com/pl/game/mortal_kombat_123",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "prehistorik_2",
            "Prehistorik 2 (1993)",
            gameUrl = "https://www.gog.com/pl/game/prehistorik_12",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "doom",
            "DOOM (1993)",
            gameUrl = "https://www.gog.com/pl/game/doom_doom_ii",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "beneath_a_steel_sky",
            "Beneath a Steel Sky (1994)",
            gameUrl = "https://www.gog.com/pl/game/beneath_a_steel_sky",
            platform = Platform.GOG,
            completed = true
        ),

        Game(
            "earthworm_jim",
            "Earthworm Jim (1994)",
            gameUrl = "https://www.gog.com/pl/game/earthworm_jim",
            platform = Platform.GOG,
            completed = true
        ),

        Game(
            "screamer",
            "Screamer (1995)",
            gameUrl = "https://www.gog.com/pl/game/screamer",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "tyrian",
            "Tyrian (1995)",
            gameUrl = "https://www.gog.com/pl/game/tyrian_2000",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "teenagent",
            "Teenagent (1995)",
            gameUrl = "https://www.gog.com/pl/game/teenagent",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "flight_of_the_amazon_queen",
            "Flight of the Amazon Queen (1995)",
            gameUrl = "https://www.gog.com/pl/game/flight_of_the_amazon_queen",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "star_wars_dark_forces",
            "STAR WARS Dark Forces (1995)",
            gameUrl = "https://www.gog.com/pl/game/star_wars_dark_forces",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "rayman",
            "Rayman (1995)",
            gameUrl = "https://www.gog.com/pl/game/rayman_forever",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "maui",
            "Maui Mallard in Cold Shadow (1996)",
            gameUrl = "https://www.gog.com/pl/game/maui_mallard_in_cold_shadow",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "gex",
            "Gex (1996)",
            gameUrl = "https://www.gog.com/pl/game/gex",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "alien_rampage",
            "Alien Rampage (1996)",
            gameUrl = "https://www.gog.com/pl/game/alien_rampage",
            platform = Platform.GOG,
            completed = true
        ),

        Game(
            "skaut",
            "Skaut Kwatemaster (1996)",
            gameUrl = "https://www.gog.com/pl/game/ad_2044",
            platform = Platform.GOG
        ),

        Game(
            "tomb_raider",
            "Tomb Raider (1996)",
            gameUrl = "https://www.gog.com/pl/game/tomb_raider_i_to_iii_remastered",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "fallout",
            "Moto Racer (1997)",
            gameUrl = "https://www.gog.com/pl/game/fallout",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "moto_racer",
            "Moto Racer (1997)",
            gameUrl = "https://www.gog.com/pl/game/moto_racer",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "lew_leon",
            "Zagadki Lwa Leona (1998)",
            gameUrl = "https://www.gog.com/pl/game/leo_the_lions_puzzles",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "jazz_jackrabbit_2",
            "Jazz Jackrabbit 2 (1998)",
            gameUrl = "https://www.gog.com/pl/game/jazz_jackrabbit_2_collection",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "metal_slug_x",
            "Metal Slug X (1999)",
            gameUrl = "https://www.gog.com/pl/game/metal_slug_x",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "rollercoaster_tycoon",
            "RollerCoaster Tycoon (1999)",
            gameUrl = "https://www.gog.com/pl/game/rollercoaster_tycoon_deluxe",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "kao",
            "Kangurek Kao (2000)",
            gameUrl = "https://www.gog.com/pl/game/kao_the_kangaroo_trilogy",
            platform = Platform.GOG
        ),

        Game(
            "dino_crisis_2",
            "Dino Crisis 2",
            gameUrl = "https://www.gog.com/pl/game/dino_crisis_2",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "aliens_versus_predator",
            "Aliens versus Predator Classic 2000 (2000)",
            gameUrl = "https://www.gog.com/pl/game/aliens_versus_predator_classic_2000",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "red_faction",
            "Red Faction (2001)",
            gameUrl = "https://www.gog.com/pl/game/red_faction",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "star_wars_galactic_battlegrounds",
            "STAR WARS Galactic Battlegrounds Saga (2001)",
            gameUrl = "https://www.gog.com/pl/game/star_wars_galactic_battlegrounds_saga",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "medal_of_honor",
            "Medal of Honor (2002)",
            gameUrl = "https://www.gog.com/pl/game/medal_of_honor_allied_assault_war_chest",
            platform = Platform.GOG,
            playable = true,
            completed = true
        ),

        Game(
            "prince",
            "Prince of Persia: The Sands of Time (2003)",
            gameUrl = "https://www.gog.com/pl/game/prince_of_persia_the_sands_of_time",
            platform = Platform.GOG
        ),

        Game(
            "streets_of_rage_4",
            "Streets of Rage 4 (2020)",
            gameUrl = "https://www.gog.com/pl/game/streets_of_rage_4",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "boulder_dash",
            "Boulder Dash Deluxe (2021)",
            gameUrl = "https://www.gog.com/pl/game/boulder_dash_deluxe",
            platform = Platform.GOG
        ),

        Game(
            "iron_meat",
            "Iron Meat (2024)",
            gameUrl = "https://www.gog.com/pl/game/iron_meat",
            platform = Platform.GOG,
            playable = true
        ),

        Game(
            "ski_jumping_world_cup",
            "Ski Jumping World Cup (2025)",
            gameUrl = "https://www.gog.com/pl/game/ski_jumping_world_cup",
            platform = Platform.GOG,
            playable = true,
            completed = true
        )
    )
}