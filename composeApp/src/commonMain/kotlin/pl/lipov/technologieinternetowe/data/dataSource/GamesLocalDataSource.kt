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
                gogUrl = "https://www.gog.com/pl/game/streets_of_rage_4"
            ),
            Game(
                id = "medal_of_honor",
                title = "Medal of Honor",
                gogUrl = "https://www.gog.com/pl/game/medal_of_honor_allied_assault_war_chest",
                completed = true
            ),
            Game(
                id = "doom",
                title = "DOOM",
                gogUrl = "https://www.gog.com/pl/game/doom_doom_ii"
            ),
            Game(
                id = "rayman",
                title = "Rayman",
                gogUrl = "https://www.gog.com/pl/game/rayman_forever",
                completed = true
            ),
            Game(
                id = "rayman_origins",
                title = "Rayman Origins",
                gogUrl = "https://www.gog.com/pl/game/rayman_origins"
            ),
            Game(
                id = "jazz_jackrabbit_2",
                title = "Jazz Jackrabbit 2",
                gogUrl = "https://www.gog.com/pl/game/jazz_jackrabbit_2_collection"
            ),
            Game(
                id = "prehistorik_2",
                title = "Prehistorik 2",
                gogUrl = "https://www.gog.com/pl/game/prehistorik_12",
                completed = true
            ),
            Game(
                id = "psychonauts",
                title = "Psychonauts",
                gogUrl = "https://www.gog.com/pl/game/psychonauts"
            ),
            Game(
                id = "screamer",
                title = "Screamer",
                gogUrl = "https://www.gog.com/pl/game/screamer"
            ),
            Game(
                id = "moto_racer",
                title = "Moto Racer",
                gogUrl = "https://www.gog.com/pl/game/moto_racer",
                completed = true
            ),
            Game(
                id = "ski_jumping_world_cup",
                title = "Ski Jumping World Cup",
                gogUrl = "https://www.gog.com/pl/game/ski_jumping_world_cup"
            ),
            Game(
                id = "rollercoaster_tycoon",
                title = "RollerCoaster Tycoon",
                gogUrl = "https://www.gog.com/pl/game/rollercoaster_tycoon_deluxe"
            ),
            Game(
                id = "fear",
                title = "F.E.A.R.",
                gogUrl = "https://www.gog.com/pl/game/fear_platinum"
            ),
            Game(
                id = "red_faction",
                title = "Red Faction",
                gogUrl = "https://www.gog.com/pl/game/red_faction"
            ),
            Game(
                id = "far_cry",
                title = "Far Cry",
                gogUrl = "https://www.gog.com/pl/game/far_cry"
            ),
            Game(
                id = "rune",
                title = "Rune",
                gogUrl = "https://www.gog.com/pl/game/rune_classic"
            ),
            Game(
                id = "prince_of_persia",
                title = "Prince of Persia: The Sands of Time",
                gogUrl = "https://www.gog.com/pl/game/prince_of_persia_the_sands_of_time"
            ),
            Game(
                id = "flight_of_the_amazon_queen",
                title = "Flight of the Amazon Queen",
                gogUrl = "https://www.gog.com/pl/game/flight_of_the_amazon_queen"
            ),
            Game(
                id = "flashback",
                title = "Flashback",
                gogUrl = "https://www.gog.com/pl/game/flashback",
                completed = true
            ),
            Game(
                id = "mortal_kombat",
                title = "Mortal Kombat",
                gogUrl = "https://www.gog.com/pl/game/mortal_kombat_123"
            ),
            Game(
                id = "crusader_no_remorse",
                title = "Crusader: No Remorse",
                gogUrl = "https://www.gog.com/pl/game/crusader_no_remorse"
            ),
            Game(
                id = "star_wars_galactic_battlegrounds",
                title = "STAR WARS Galactic Battlegrounds Saga",
                gogUrl = "https://www.gog.com/pl/game/star_wars_galactic_battlegrounds_saga"
            ),
            Game(
                id = "dino_crisis_2",
                title = "Dino Crisis 2",
                gogUrl = "https://www.gog.com/pl/game/dino_crisis_2"
            ),
            Game(
                id = "tomb_raider",
                title = "Tomb Raider",
                gogUrl = "https://www.gog.com/pl/game/tomb_raider_i_to_iii_remastered",
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
