package pl.lipov.technologieinternetowe

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "TechnologieInternetowe",
        resizable = false,
        undecorated = false
    ) {
        window.extendedState = java.awt.Frame.MAXIMIZED_BOTH
        App()
    }
}

