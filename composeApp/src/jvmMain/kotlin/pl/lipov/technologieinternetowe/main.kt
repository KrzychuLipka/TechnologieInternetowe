package pl.lipov.technologieinternetowe

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "CD Action Retro",
        resizable = false,
        undecorated = false
    ) {
        window.extendedState = java.awt.Frame.MAXIMIZED_BOTH
        App()
    }
}

