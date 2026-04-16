package pl.lipov.technologieinternetowe.presentation

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.Flow

@Composable
fun UiEventHandler(
    events: Flow<UiEvent>
) {
    var currentEvent by remember { mutableStateOf<UiEvent?>(null) }
    LaunchedEffect(Unit) {
        events.collect { event ->
            currentEvent = event
        }
    }
    currentEvent?.let { uiEvent ->
        when (uiEvent) {
            is UiEvent.ShowMessage -> {
                AlertDialog(
                    title = { Text(uiEvent.message) },
                    confirmButton = {
                        TextButton(
                            onClick = { currentEvent = null }
                        ) {
                            Text("OK")
                        }
                    },
                    onDismissRequest = {
                        currentEvent = null
                    },
                )
            }
        }
    }
}
