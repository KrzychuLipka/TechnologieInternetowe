package pl.lipov.technologieinternetowe.presentation.discCoverMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.painterResource
import pl.lipov.technologieinternetowe.data.dataSource.HttpClientProvider
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.cd

@Composable
fun DiscCoverScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = remember { DiscCoverMenuViewModel() }
    val games by viewModel.games.collectAsState()
    val magazineNumber by viewModel.magazineNumber.collectAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(9),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items((1..9).toList()) { number ->
                Box(
                    modifier = Modifier
                        .clickable { viewModel.setMagazineNumber(number) }
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "#$number",
                        color = if (number == magazineNumber) Color.Red else Color.White,
                        fontWeight = if (number == magazineNumber) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

        Row {
            KamelImage(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                resource = {
                    asyncPainterResource("http://${HttpClientProvider.HOST}:${HttpClientProvider.PORT}/images/retro$magazineNumber.png")
                },
                contentDescription = "Cover CD",
                onLoading = {
                    Text(
                        "Ładowanie okładki...",
                        modifier = Modifier.align(Alignment.Center)
                    )
                },
                onFailure = { error ->
                    Text(
                        "Błąd ładowania: ${error.message}",
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            )

            Box(
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(Res.drawable.cd),
                    contentDescription = "Cover CD",
                    modifier = Modifier.fillMaxSize()
                )
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.5f)
                        .padding(start = 64.dp)
                ) {
                    items(games) { game ->
                        Text(
                            text = game.title,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red,
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .clickable {
                                    if (game.playable) {
                                        game.gameUrl?.let { viewModel.playGame(it) }
                                    }
                                }
                        )
                    }
                }
            }
        }
    }
}
