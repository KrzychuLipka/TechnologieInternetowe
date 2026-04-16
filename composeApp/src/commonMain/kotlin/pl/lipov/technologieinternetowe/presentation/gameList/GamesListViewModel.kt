package pl.lipov.technologieinternetowe.presentation.gameList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pl.lipov.technologieinternetowe.data.repository.GamesRemoteRepository
import pl.lipov.technologieinternetowe.domain.model.ApiResult
import pl.lipov.technologieinternetowe.domain.model.Game
import pl.lipov.technologieinternetowe.domain.useCase.GetAllGamesUseCase
import pl.lipov.technologieinternetowe.domain.useCase.RefreshGamesUseCase
import pl.lipov.technologieinternetowe.domain.useCase.ToggleGameCompletionStateUseCase
import pl.lipov.technologieinternetowe.domain.utils.openGameUrl
import pl.lipov.technologieinternetowe.domain.utils.runGame
import pl.lipov.technologieinternetowe.presentation.UiEvent
import pl.lipov.technologieinternetowe.presentation.UiMessenger

class GamesListViewModel(
    private val uiMessenger: UiMessenger
) : ViewModel() {

    companion object {
        private const val STOP_SUBSCRIPTION_TIMEOUT_MS = 5_000L
    }

    private val repository = GamesRemoteRepository()

    private val getAllGamesUseCase = GetAllGamesUseCase(
        repository = repository
    )
    private val toggleGameCompletionState = ToggleGameCompletionStateUseCase(
        repository = repository
    )
    private val refreshGames = RefreshGamesUseCase(
        repository = repository
    )

    init {
        viewModelScope.launch {
            refreshGames().handle()
        }
    }

    private fun <T> ApiResult<T>.handle(
        onSuccess: (T) -> Unit = {}
    ) {
        when (this) {
            is ApiResult.Success -> onSuccess(data)

            is ApiResult.Error -> {
                viewModelScope.launch {
                    uiMessenger.sendUiEvent(
                        UiEvent.ShowMessage(mapError(code))
                    )
                }
            }
        }
    }

    private fun mapError(
        code: String?
    ): String {
        return when (code) {
            "GAME_NOT_FOUND" -> "Nie znaleziono gry"
            "VALIDATION_ERROR" -> "Błędne dane"
            "BAD_REQUEST" -> "Niepoprawne żądanie"
            else -> "Coś poszło nie tak: $code"
        }
    }

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
            toggleGameCompletionState(gameId).handle()
        }
    }
}
