package pl.lipov.technologieinternetowe.presentation

sealed interface UiEvent {

    data class ShowMessage(
        val message: String
    ) : UiEvent
}
