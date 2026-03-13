package pl.lipov.technologieinternetowe.data.dataSource

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pl.lipov.technologieinternetowe.domain.model.Game

object GamesLocalDataSource {

    private var _games = MutableStateFlow(
        listOf(
            Game(
                id = "streets_of_rage_4",
                title = "Streets of Rage 4",
                magazineNumber = 1,
                lastPlayed = 2026,
                gogUrl = "https://www.gog.com/pl/game/streets_of_rage_4"
            ),
//            Game(
//                id = "stargunner",
//                title = "Stargunner",
//                magazineNr = 1,
//                lastPlayed = 2026,
//                gogUrl = "https://www.gog.com/pl/game/stargunner"
//            ),
//            Game(
//                id = "medal_of_honor",
//                title = "Medal of Honor",
//                gogUrl = "https://www.gog.com/pl/game/medal_of_honor_allied_assault_war_chest",
//                magazineNr = 2,
//                lastPlayed = 2026,
//                completed = true
//            ),
//            Game(// TODO czekam na promocję
//                id = "quake_iii_arena",
//                title = "Quake III Arena",
//                gogUrl = "https://www.gog.com/pl/game/quake_iii_arena",
//                magazineNr = 2
//            ),
            Game(
                id = "doom",
                title = "DOOM",
                gogUrl = "https://www.gog.com/pl/game/doom_doom_ii",
                magazineNumber = 2,
                lastPlayed = 2026,
                additionalGames = listOf(
                    "DOOM II + dodatki"
                )
            ),
//            Game(
//                id = "wolfenstein_3d",
//                title = "Wolfenstein 3D",
//                gogUrl = "https://www.gog.com/pl/game/wolfenstein_3d",
//                magazineNr = 2,
//                lastPlayed = 2026,
//            ),
            Game(
                id = "psychonauts",
                title = "Psychonauts",
                gogUrl = "https://www.gog.com/pl/game/psychonauts",
                magazineNumber = 2,
                lastPlayed = 2026,
            ),
//            Game(
//                id = "rayman_origins",
//                title = "Rayman Origins",
//                gogUrl = "https://www.gog.com/pl/game/rayman_origins",
//                magazineNr = 2,
//                lastPlayed = 2019,
//            ),
//            Game(
//                id = "rayman",
//                title = "Rayman",
//                gogUrl = "https://www.gog.com/pl/game/rayman_forever",
//                magazineNr = 2,
//                lastPlayed = 2024,
//                completed = true
//            ),
//            Game(
//                id = "jazz_jackrabbit_2",
//                title = "Jazz Jackrabbit 2",
//                gogUrl = "https://www.gog.com/pl/game/jazz_jackrabbit_2_collection",
//                magazineNr = 2,
//                lastPlayed = 2008,
//                additionalGames = listOf(
//                    "Jazz Jackrabbit 2: The Christmass Chronicles"
//                )
//            ),
//            Game(// TODO czekam na promocję
//                id = "earthworm_jim",
//                title = "Earthworm Jim",
//                gogUrl = "https://www.gog.com/pl/game/earthworm_jim",
//                magazineNr = 2,
//                lastPlayed = 2025,
//                completed = true
//            ),
//            Game(
//                id = "prehistorik_2",
//                title = "Prehistorik 2",
//                gogUrl = "https://www.gog.com/pl/game/prehistorik_12",
//                magazineNr = 2,
//                lastPlayed = 2026,
//                completed = true
//            ),
//            Game(
//                id = "lew_leon",
//                title = "Zagadki Lwa Leona",
//                gogUrl = "https://www.gog.com/pl/game/leo_the_lions_puzzles",
//                magazineNr = 2,
//                lastPlayed = 2026,
//                completed = true
//            ),
//            Game(
//                id = "commander_keen_complete_pack",
//                title = "Commander Keen",
//                gogUrl = "https://www.gog.com/pl/game/commander_keen_complete_pack",
//                magazineNr = 2,
//                lastPlayed = 2026
//            ),
            Game(
                id = "screamer",
                title = "Screamer",
                gogUrl = "https://www.gog.com/pl/game/screamer",
                magazineNumber = 2,
                lastPlayed = 2026,
            ),
//            Game(
//                id = "moto_racer",
//                title = "Moto Racer",
//                gogUrl = "https://www.gog.com/pl/game/moto_racer",
//                magazineNr = 2,
//                lastPlayed = 2026,
//                completed = true,
//                additionalGames = listOf(
//                    "Moto Racer 2",
//                    "Moto Racer 3"
//                )
//            ),
//            Game(
//                id = "ski_jumping_world_cup",
//                title = "Ski Jumping World Cup",
//                gogUrl = "https://www.gog.com/pl/game/ski_jumping_world_cup",
//                magazineNr = 2,
//                lastPlayed = 2026
//            ),
//            Game(
//                id = "rollercoaster_tycoon",
//                title = "RollerCoaster Tycoon",
//                gogUrl = "https://www.gog.com/pl/game/rollercoaster_tycoon_deluxe",
//                magazineNr = 2
//            ),
//            Game(// TODO Czekam na promocję
//                id = "resident_evil",
//                title = "Resident Evil",
//                gogUrl = "https://www.gog.com/pl/game/resident_evil",
//                magazineNr = 3
//            ),
            Game(
                id = "fear",
                title = "F.E.A.R.",
                gogUrl = "https://www.gog.com/pl/game/fear_platinum",
                magazineNumber = 3,
                lastPlayed = 2026
            ),
//            Game(
//                id = "aliens_versus_predator",
//                title = "Aliens versus Predator Classic 2000",
//                gogUrl = "https://www.gog.com/pl/game/aliens_versus_predator_classic_2000",
//                magazineNr = 3,
//                lastPlayed = 2025
//            ),
//            Game(
//                id = "painkiller",
//                title = "Painkiller",
//                gogUrl = "https://www.gog.com/pl/game/painkiller",
//                magazineNr = 3
//            ),
//            Game(//TODO pobrać pliki
//                id = "the_witcher",
//                title = "Wiedźmin",
//                gogUrl = "https://www.gog.com/pl/game/the_witcher",
//                magazineNr = 4,
//                lastPlayed = 2025,
//                additionalGames = listOf(
//                    "Wiedźmin 3"
//                )
//            ),
//            Game(
//                id = "far_cry",
//                title = "Far Cry",
//                gogUrl = "https://www.gog.com/pl/game/far_cry",
//                magazineNr = 4,
//                lastPlayed = 2026
//            ),
//            Game(
//                id = "red_faction",
//                title = "Red Faction",
//                gogUrl = "https://www.gog.com/pl/game/red_faction",
//                magazineNr = 4
//            ),
            Game(
                id = "rune",
                title = "Rune",
                gogUrl = "https://www.gog.com/pl/game/rune_classic",
                magazineNumber = 5,
                lastPlayed = 2026
            ),
//            Game(
//                id = "prince_of_persia",
//                title = "Prince of Persia: The Sands of Time",
//                gogUrl = "https://www.gog.com/pl/game/prince_of_persia_the_sands_of_time",
//                magazineNr = 5
//            ),
//            Game(
//                id = "flashback",
//                title = "Flashback",
//                gogUrl = "https://www.gog.com/pl/game/flashback",
//                magazineNr = 5,
//                lastPlayed = 2025,
//                completed = true
//            ),
//            Game(
//                id = "beneath_a_steel_sky",
//                title = "Beneath a Steel Sky",
//                gogUrl = "https://www.gog.com/pl/game/beneath_a_steel_sky",
//                magazineNr = 5,
//                lastPlayed = 2025,
//                completed = true
//            ),
//            Game(// TODO czekam na promocję
//                id = "indiana_jones_and_the_fate_of_atlantis",
//                title = "Indiana Jones® and the Fate of Atlantis",
//                gogUrl = "https://www.gog.com/pl/game/indiana_jones_and_the_fate_of_atlantis",
//                magazineNr = 5,
//                lastPlayed = 2025,
//                completed = true
//            ),
//            Game(
//                id = "flight_of_the_amazon_queen",
//                title = "Flight of the Amazon Queen",
//                gogUrl = "https://www.gog.com/pl/game/flight_of_the_amazon_queen",
//                magazineNr = 5,
//                lastPlayed = 2026
//            ),
//            Game(
//                id = "lure_of_the_temptress",
//                title = "Lure of the Temptress",
//                gogUrl = "https://www.gog.com/pl/game/lure_of_the_temptress",
//                magazineNr = 5
//            ),
//            Game(// TODO pobrać pliki
//                id = "police_quest",
//                title = "Police Quest Collection",
//                gogUrl = "https://www.gog.com/pl/game/police_quest_collection",
//                magazineNr = 5,
//                lastPlayed = 2025
//            ),
            Game(
                id = "teenagent",
                title = "Teenagent",
                gogUrl = "https://www.gog.com/pl/game/teenagent",
                magazineNumber = 5,
                lastPlayed = 2026,
                completed = true
            ),
//            Game(
//                id = "galador",
//                title = "Książę i Tchórz",
//                gogUrl = "https://www.gog.com/pl/game/galador_the_prince_and_the_coward",
//                magazineNr = 5,
//                lastPlayed = 2026
//            ),
//            Game(
//                id = "mortal_kombat",
//                title = "Mortal Kombat",
//                gogUrl = "https://www.gog.com/pl/game/mortal_kombat_123",
//                magazineNr = 6,
//                lastPlayed = 2026,
//                additionalGames = listOf(
//                    "Mortal Kombat 2",
//                    "Mortal Kombat 3"
//                )
//            ),
            Game(// TODO pobrać pliki
                id = "fallout",
                title = "Fallout",
                gogUrl = "https://www.gog.com/pl/game/fallout",
                magazineNumber = 7,
                lastPlayed = 2026,
                completed = true
            ),
//            Game(
//                id = "crusader_no_remorse",
//                title = "Crusader: No Remorse",
//                gogUrl = "https://www.gog.com/pl/game/crusader_no_remorse",
//                magazineNr = 7
//            ),
//            Game(
//                id = "star_wars_galactic_battlegrounds",
//                title = "STAR WARS Galactic Battlegrounds Saga",
//                gogUrl = "https://www.gog.com/pl/game/star_wars_galactic_battlegrounds_saga",
//                magazineNr = 8,
//                lastPlayed = 2026
//            ),
            Game(
                id = "star_wars_dark_forces",
                title = "STAR WARS Dark Forces",
                gogUrl = "https://www.gog.com/pl/game/star_wars_dark_forces",
                magazineNumber = 8,
                lastPlayed = 2026
            ),
//            Game(
//                id = "dino_crisis_2",
//                title = "Dino Crisis 2",
//                gogUrl = "https://www.gog.com/pl/game/dino_crisis_2",
//                magazineNr = 9,
//                lastPlayed = 2004,
//                additionalGames = listOf(
//                    "Dino Crisis"
//                )
//            ),
            Game(
                id = "tomb_raider",
                title = "Tomb Raider",
                gogUrl = "https://www.gog.com/pl/game/tomb_raider_i_to_iii_remastered",
                magazineNumber = 9,
                lastPlayed = 2026,
                completed = true
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
