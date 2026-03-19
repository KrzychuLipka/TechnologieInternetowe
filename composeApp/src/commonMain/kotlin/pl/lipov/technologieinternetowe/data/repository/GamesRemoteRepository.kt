package pl.lipov.technologieinternetowe.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import pl.lipov.technologieinternetowe.data.dataSource.GamesRemoteDataSource
import pl.lipov.technologieinternetowe.data.mapper.toGame
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.repository.GamesRepository

class GamesRemoteRepository : GamesRepository {

    private val _games = MutableStateFlow<List<Game>>(emptyList())

    override fun getAllGames(
        magazineNumber: Int
    ): Flow<List<Game>> =
        _games.map { list ->
            list.filter { it.magazineNumber == magazineNumber }
        }

    override suspend fun toggleGameCompletion(gameId: String) {
        _games.value = _games.value.map { game ->
            if (game.id == gameId) game.copy(completed = !game.completed)
            else game
        }
    }

    override suspend fun refresh() {
        val remoteGames = GamesRemoteDataSource.getAllGames()
        _games.value = remoteGames.map { it.toGame() }
    }
}
