package pl.lipov.technologieinternetowe.data.dataSource

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pl.lipov.technologieinternetowe.domain.model.Game

object GamesLocalDataSource {

    private var _games = MutableStateFlow(GamesRepository.games)
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
