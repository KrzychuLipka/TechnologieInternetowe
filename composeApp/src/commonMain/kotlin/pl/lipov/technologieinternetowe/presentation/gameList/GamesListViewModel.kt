package pl.lipov.technologieinternetowe.presentation.gameList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pl.lipov.technologieinternetowe.data.repository.GamesLocalRepository
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.useCase.GetAllGamesUseCase
import pl.lipov.technologieinternetowe.domain.useCase.ToggleGameCompletionStateUseCase
import pl.lipov.technologieinternetowe.domain.utils.openGameUrl
import pl.lipov.technologieinternetowe.domain.utils.runGame

class GamesListViewModel : ViewModel() {

    companion object {
        private const val STOP_SUBSCRIPTION_TIMEOUT_MS = 5_000L
    }

    private val getAllGamesUseCase = GetAllGamesUseCase(
        repository = GamesLocalRepository()
    )
    private val toggleGameCompletionStateUseCase = ToggleGameCompletionStateUseCase(
        repository = GamesLocalRepository()
    )

    fun getAllGames(
        magazineNumber: Int
    ): StateFlow<List<Game>> =
        getAllGamesUseCase(magazineNumber)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(STOP_SUBSCRIPTION_TIMEOUT_MS),
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

    fun handleToggleGameCompletionButtonClick(
        gameId: String
    ) {
        viewModelScope.launch {
            toggleGameCompletionStateUseCase(gameId)
        }
    }
}
