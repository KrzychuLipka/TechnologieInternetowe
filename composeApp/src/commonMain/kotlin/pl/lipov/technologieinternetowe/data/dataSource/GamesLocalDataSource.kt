package pl.lipov.technologieinternetowe.data.dataSource

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.model.Platform

object GamesLocalDataSource {

    private var _games = MutableStateFlow(
        listOf(
            Game(
                id = "franko",
                title = "Franko: The Crazy Revenge",
                magazineNumber = 1,
                lastPlayed = 2026,
                platform = Platform.DOS,
                playable = true
            ),
            Game(
                id = "streets_of_rage_4",
                title = "Streets of Rage 4",
                magazineNumber = 1,
                lastPlayed = 2026,
                gameUrl = "https://www.gog.com/pl/game/streets_of_rage_4",
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "stargunner",
                title = "Stargunner",
                magazineNumber = 1,
                lastPlayed = 2026,
                gameUrl = "https://www.gog.com/pl/game/stargunner",
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "wolfenstein_3d",
                title = "Wolfenstein 3D",
                gameUrl = "https://www.gog.com/pl/game/wolfenstein_3d",
                magazineNumber = 2,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "doom",
                title = "DOOM",
                gameUrl = "https://www.gog.com/pl/game/doom_doom_ii",
                magazineNumber = 2,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "half_life",
                title = "Half-Life",
                magazineNumber = 2,
                lastPlayed = 2025,
                gameUrl = "https://store.steampowered.com/app/70/HalfLife/",
                platform = Platform.STEAM,
                completed = true
            ),
            Game(
                id = "medal_of_honor",
                title = "Medal of Honor",
                gameUrl = "https://www.gog.com/pl/game/medal_of_honor_allied_assault_war_chest",
                magazineNumber = 2,
                lastPlayed = 2026,
                platform = Platform.GOG,
                completed = true,
                playable = true
            ),
            Game(
                id = "battlefield_1",
                title = "Battlefield 1",
                magazineNumber = 2,
                lastPlayed = 2023,
                gameUrl = "https://store.steampowered.com/app/1238840/Battlefield_1/",
                platform = Platform.STEAM
            ),
            Game(
                id = "superfrog",
                title = "superfrog",
                magazineNumber = 2,
                lastPlayed = 2025,
                platform = Platform.AMIGA,
                playable = true,
                completed = true
            ),
            Game(
                id = "james_pond_2",
                title = "James Pond 2",
                magazineNumber = 2,
                lastPlayed = 2025,
                platform = Platform.AMIGA,
                playable = true
            ),
            Game(
                id = "ruff_tumble",
                title = "Ruff 'n' Tumble",
                magazineNumber = 2,
                lastPlayed = 2025,
                platform = Platform.AMIGA,
                playable = true
            ),
            Game(
                id = "traps_treasures",
                title = "Traps 'n' Treasures",
                magazineNumber = 2,
                lastPlayed = 2025,
                platform = Platform.AMIGA,
                playable = true
            ),
            Game(
                id = "zool_2",
                title = "Zool 2",
                magazineNumber = 2,
                lastPlayed = 2025,
                platform = Platform.AMIGA,
                playable = true
            ),
            Game(
                id = "qwak",
                title = "Qwak",
                magazineNumber = 2,
                lastPlayed = 2025,
                platform = Platform.AMIGA,
                playable = true
            ),
            Game(
                id = "donkey_kong_country_2",
                title = "Donkey Kong Country 2: Diddy's Kong Quest",
                magazineNumber = 2,
                lastPlayed = 2025,
                platform = Platform.SNES,
                playable = true
            ),
            Game(
                id = "commander_keen_complete_pack",
                title = "Commander Keen",
                gameUrl = "https://www.gog.com/pl/game/commander_keen_complete_pack",
                magazineNumber = 2,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "prehistorik_2",
                title = "Prehistorik 2",
                gameUrl = "https://www.gog.com/pl/game/prehistorik_12",
                magazineNumber = 2,
                lastPlayed = 2026,
                completed = true,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "earthworm_jim",
                title = "Earthworm Jim",
                gameUrl = "https://www.gog.com/pl/game/earthworm_jim",
                magazineNumber = 2,
                lastPlayed = 2025,
                completed = true,
                platform = Platform.GOG
            ),
            Game(
                id = "rayman",
                title = "Rayman",
                gameUrl = "https://www.gog.com/pl/game/rayman_forever",
                magazineNumber = 2,
                completed = true,
                lastPlayed = 2024,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "rayman_origins",
                title = "Rayman Origins",
                gameUrl = "https://www.gog.com/pl/game/rayman_origins",
                magazineNumber = 2,
                lastPlayed = 2019,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "jazz_jackrabbit_2",
                title = "Jazz Jackrabbit 2",
                gameUrl = "https://www.gog.com/pl/game/jazz_jackrabbit_2_collection",
                magazineNumber = 2,
                lastPlayed = 2008,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "psychonauts",
                title = "Psychonauts",
                gameUrl = "https://www.gog.com/pl/game/psychonauts",
                magazineNumber = 2,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "screamer",
                title = "Screamer",
                gameUrl = "https://www.gog.com/pl/game/screamer",
                magazineNumber = 2,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "moto_racer",
                title = "Moto Racer",
                gameUrl = "https://www.gog.com/pl/game/moto_racer",
                magazineNumber = 2,
                lastPlayed = 2026,
                completed = true,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "ski_jumping_world_cup",
                title = "Ski Jumping World Cup",
                gameUrl = "https://www.gog.com/pl/game/ski_jumping_world_cup",
                magazineNumber = 2,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "rollercoaster_tycoon",
                title = "RollerCoaster Tycoon",
                gameUrl = "https://www.gog.com/pl/game/rollercoaster_tycoon_deluxe",
                magazineNumber = 2,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "darkseed",
                title = "Dark Seed",
                magazineNumber = 3,
                platform = Platform.AMIGA,
                playable = true,
                lastPlayed = 2025
            ),
            Game(
                id = "splatterhouse_3",
                title = "Splatterhouse 3",
                magazineNumber = 3,
                platform = Platform.MEGA_DRIVE,
                playable = true,
                lastPlayed = 2025
            ),
            Game(
                id = "resident_evil",
                title = "Resident Evil",
                gameUrl = "https://www.gog.com/pl/game/resident_evil",
                magazineNumber = 3,
                platform = Platform.GOG,
                lastPlayed = 2025
            ),
            Game(
                id = "aliens_versus_predator",
                title = "Aliens versus Predator Classic 2000",
                gameUrl = "https://www.gog.com/pl/game/aliens_versus_predator_classic_2000",
                magazineNumber = 3,
                lastPlayed = 2025,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "painkiller",
                title = "Painkiller",
                gameUrl = "https://www.gog.com/pl/game/painkiller",
                magazineNumber = 3,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "fear",
                title = "F.E.A.R.",
                gameUrl = "https://www.gog.com/pl/game/fear_platinum",
                magazineNumber = 3,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "red_faction",
                title = "Red Faction",
                gameUrl = "https://www.gog.com/pl/game/red_faction",
                magazineNumber = 4,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "far_cry",
                title = "Far Cry",
                gameUrl = "https://www.gog.com/pl/game/far_cry",
                magazineNumber = 4,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "the_witcher",
                title = "Wiedźmin",
                gameUrl = "https://www.gog.com/pl/game/the_witcher",
                magazineNumber = 4,
                lastPlayed = 2025,
                platform = Platform.GOG
            ),
            Game(
                id = "police_quest",
                title = "Police Quest Collection",
                gameUrl = "https://www.gog.com/pl/game/police_quest_collection",
                magazineNumber = 5,
                lastPlayed = 2025,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "lure_of_the_temptress",
                title = "Lure of the Temptress",
                gameUrl = "https://www.gog.com/pl/game/lure_of_the_temptress",
                magazineNumber = 5,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "indiana_jones_and_the_fate_of_atlantis",
                title = "Indiana Jones® and the Fate of Atlantis",
                gameUrl = "https://www.gog.com/pl/game/indiana_jones_and_the_fate_of_atlantis",
                magazineNumber = 5,
                lastPlayed = 2025,
                completed = true,
                platform = Platform.STEAM
            ),
            Game(
                id = "beneath_a_steel_sky",
                title = "Beneath a Steel Sky",
                gameUrl = "https://www.gog.com/pl/game/beneath_a_steel_sky",
                magazineNumber = 5,
                lastPlayed = 2025,
                completed = true,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "flight_of_the_amazon_queen",
                title = "Flight of the Amazon Queen",
                gameUrl = "https://www.gog.com/pl/game/flight_of_the_amazon_queen",
                magazineNumber = 5,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "teenagent",
                title = "Teenagent",
                gameUrl = "https://www.gog.com/pl/game/teenagent",
                magazineNumber = 5,
                lastPlayed = 2026,
                completed = true,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "skaut",
                title = "Skaut Kwatemaster",
                magazineNumber = 5,
                lastPlayed = 2025,
                platform = Platform.WIN95,
                playable = true
            ),
            Game(
                id = "galador",
                title = "Książę i Tchórz",
                gameUrl = "https://www.gog.com/pl/game/galador_the_prince_and_the_coward",
                magazineNumber = 5,
                lastPlayed = 2026,
                platform = Platform.GOG
            ),
            Game(
                id = "flashback",
                title = "Flashback",
                gameUrl = "https://www.gog.com/pl/game/flashback",
                magazineNumber = 5,
                lastPlayed = 2025,
                completed = true,
                platform = Platform.GOG
            ),
            Game(
                id = "lionheart",
                title = "Lionheart",
                magazineNumber = 5,
                lastPlayed = 2025,
                platform = Platform.AMIGA,
                playable = true
            ),
            Game(
                id = "rune",
                title = "Rune",
                gameUrl = "https://www.gog.com/pl/game/rune_classic",
                magazineNumber = 5,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "prince_of_persia",
                title = "Prince of Persia: The Sands of Time",
                gameUrl = "https://www.gog.com/pl/game/prince_of_persia_the_sands_of_time",
                magazineNumber = 5,
                lastPlayed = 2008,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "mortal_kombat",
                title = "Mortal Kombat",
                gameUrl = "https://www.gog.com/pl/game/mortal_kombat_123",
                magazineNumber = 6,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "blade_runner",
                title = "Blade Runner",
                magazineNumber = 6,
                lastPlayed = 2025,
                gameUrl = "https://store.steampowered.com/app/1678420/Blade_Runner_Enhanced_Edition/",
                platform = Platform.STEAM
            ),
            Game(
                id = "robo_cop",
                title = "RoboCop: Rogue City",
                magazineNumber = 6,
                lastPlayed = 2025,
                gameUrl = "https://store.steampowered.com/app/1681430/RoboCop_Rogue_City/",
                platform = Platform.STEAM
            ),
            Game(
                id = "max_payne",
                title = "Max Payne",
                magazineNumber = 6,
                lastPlayed = 2024,
                gameUrl = "https://store.steampowered.com/app/12140/Max_Payne/",
                platform = Platform.STEAM,
                completed = true
            ),
            Game(
                id = "gta4",
                title = "Grand Theft Auto IV",
                magazineNumber = 6,
                lastPlayed = 2025,
                gameUrl = "https://store.steampowered.com/app/12210/Grand_Theft_Auto_IV_The_Complete_Edition/",
                platform = Platform.STEAM
            ),
            Game(
                id = "crusader_no_remorse",
                title = "Crusader: No Remorse",
                gameUrl = "https://www.gog.com/pl/game/crusader_no_remorse",
                magazineNumber = 7,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "fallout",
                title = "Fallout",
                gameUrl = "https://www.gog.com/pl/game/fallout",
                magazineNumber = 7,
                platform = Platform.GOG,
                completed = true
            ),
            Game(
                id = "star_wars_dark_forces",
                title = "STAR WARS Dark Forces",
                gameUrl = "https://www.gog.com/pl/game/star_wars_dark_forces",
                magazineNumber = 8,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "star_wars_galactic_battlegrounds",
                title = "STAR WARS Galactic Battlegrounds Saga",
                gameUrl = "https://www.gog.com/pl/game/star_wars_galactic_battlegrounds_saga",
                magazineNumber = 8,
                lastPlayed = 2026,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "boulder_dash",
                title = "Boulder Dash",
                magazineNumber = 9,
                lastPlayed = 2025,
                platform = Platform.ATARI,
                playable = true
            ),
            Game(
                id = "river_raid",
                title = "River Raid",
                magazineNumber = 9,
                lastPlayed = 2025,
                platform = Platform.ATARI,
                playable = true
            ),
            Game(
                id = "fire_fight",
                title = "Fire Fight",
                magazineNumber = 9,
                lastPlayed = 2025,
                platform = Platform.WIN95,
                playable = true
            ),
            Game(
                id = "miecze_valdgira",
                title = "Miecze Valdgira",
                magazineNumber = 9,
                lastPlayed = 2025,
                platform = Platform.ATARI,
                playable = true,
                completed = true
            ),
            Game(
                id = "tony",
                title = "Tony",
                magazineNumber = 9,
                lastPlayed = 2025,
                platform = Platform.ATARI,
                playable = true
            ),
            Game(
                id = "lew_leon",
                title = "Zagadki Lwa Leona",
                gameUrl = "https://www.gog.com/pl/game/leo_the_lions_puzzles",
                magazineNumber = 9,
                lastPlayed = 2025,
                completed = true,
                platform = Platform.GOG,
                playable = true,
            ),
            Game(
                id = "kao",
                title = "Kangurek Kao",
                gameUrl = "https://www.gog.com/pl/game/kao_the_kangaroo_trilogy",
                magazineNumber = 9,
                lastPlayed = 2025,
                platform = Platform.GOG
            ),
            Game(
                id = "tomb_raider",
                title = "Tomb Raider",
                gameUrl = "https://www.gog.com/pl/game/tomb_raider_i_to_iii_remastered",
                magazineNumber = 9,
                lastPlayed = 2026,
                completed = true,
                platform = Platform.GOG,
                playable = true
            ),
            Game(
                id = "dino_crisis_2",
                title = "Dino Crisis 2",
                gameUrl = "https://www.gog.com/pl/game/dino_crisis_2",
                magazineNumber = 9,
                lastPlayed = 2004,
                platform = Platform.GOG,
                playable = true
            )
        )
    )
    val games: StateFlow<List<Game>> = _games.asStateFlow()

    fun toggleGameCompletion(
        gameId: String
    ) {
        _games.update { gamesList ->
            gamesList.map { game ->
                if (game.id == gameId) {
                    game.copy(completed = !game.completed)
                } else {
                    game
                }
            }
        }
    }
}
