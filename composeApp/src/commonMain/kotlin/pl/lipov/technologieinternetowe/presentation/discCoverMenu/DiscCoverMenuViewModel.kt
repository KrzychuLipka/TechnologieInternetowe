package pl.lipov.technologieinternetowe.presentation.discCoverMenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pl.lipov.technologieinternetowe.data.repository.GamesRemoteRepository
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.useCase.GetAllGamesUseCase
import pl.lipov.technologieinternetowe.domain.useCase.PlayGameUseCase

class DiscCoverMenuViewModel : ViewModel() {

    private val getAllGamesUseCase = GetAllGamesUseCase(
        repository = GamesRemoteRepository()
    )
    private val playGameUseCase = PlayGameUseCase(
        repository = GamesRemoteRepository()
    )

    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games: StateFlow<List<Game>> = _games
    private val _magazineNumber = MutableStateFlow(1)
    val magazineNumber: StateFlow<Int> = _magazineNumber

    init {
        fetchAllGames()
    }

    private fun fetchAllGames() {
        viewModelScope.launch {
            _games.value = getAllGamesUseCase(_magazineNumber.value)
        }
    }

    fun playGame(
        gameUrl: String
    ) {
        viewModelScope.launch {
            playGameUseCase(gameUrl)
        }
    }

    fun setMagazineNumber(
        number: Int
    ) {
        _magazineNumber.value = number
        fetchAllGames()
    }
}
