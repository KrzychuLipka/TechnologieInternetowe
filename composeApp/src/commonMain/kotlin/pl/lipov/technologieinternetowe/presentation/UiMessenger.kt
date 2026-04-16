package pl.lipov.technologieinternetowe.presentation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class UiMessenger {

    private val _events = MutableSharedFlow<UiEvent>()
    val events: SharedFlow<UiEvent> = _events

    suspend fun sendUiEvent(
        uiEvent: UiEvent
    ) {
        _events.emit(uiEvent)
    }
}
