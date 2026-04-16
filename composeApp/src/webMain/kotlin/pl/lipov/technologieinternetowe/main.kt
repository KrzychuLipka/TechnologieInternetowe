package pl.lipov.technologieinternetowe

import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import pl.lipov.technologieinternetowe.presentation.UiEventHandler
import pl.lipov.technologieinternetowe.presentation.UiMessenger

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {

        App()
    }
}