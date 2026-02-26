package pl.lipov.technologieinternetowe.presentation.gamesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pl.lipov.technologieinternetowe.data.repository.GamesRemoteRepository
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.useCase.GetAllGamesUseCase

class GamesListViewModel : ViewModel() {

    private val getAllGamesUseCase = GetAllGamesUseCase(
        repository = GamesRemoteRepository()
    )

    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games: StateFlow<List<Game>> = _games

    init {
        fetchAllGames()
    }

    private fun fetchAllGames() {
        viewModelScope.launch {
            _games.value = getAllGamesUseCase()
        }
    }
}
