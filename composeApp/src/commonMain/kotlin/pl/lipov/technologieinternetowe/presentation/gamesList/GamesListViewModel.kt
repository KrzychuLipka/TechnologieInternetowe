package pl.lipov.technologieinternetowe.presentation.gamesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pl.lipov.technologieinternetowe.data.repository.GamesLocalRepository
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.useCase.GetAllGamesUseCase
import pl.lipov.technologieinternetowe.domain.utils.openGameUrl
import pl.lipov.technologieinternetowe.domain.utils.runGame

class GamesListViewModel : ViewModel() {

    private val getAllGamesUseCase = GetAllGamesUseCase(
        repository = GamesLocalRepository()
    )

    val games: StateFlow<List<Game>> =
        getAllGamesUseCase()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = emptyList()
            )

    fun handleGameUrlClick(
        url: String
    ) {
        openGameUrl(url)
    }

    fun handleRunGameButtonClick(
        gameId: String
    ) {
        viewModelScope.launch {
            runGame(gameId)
        }
    }
}
