package pl.lipov.technologieinternetowe.presentation.magazineList

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import pl.lipov.technologieinternetowe.presentation.theme.Dimens

private val MAGAZINE_NUMBERS = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

@Composable
fun MagazineListScreen(
    modifier: Modifier = Modifier,
    gridState: LazyGridState,
    onMagazineNumberSelected: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = Dimens.MagazineMainPageWidth),
        modifier = modifier,
        state = gridState
    ) {
        items(MAGAZINE_NUMBERS) { number ->
            MagazineItem(
                magazineNumber = number,
                onMagazineNumberSelected = { onMagazineNumberSelected(it) }
            )
        }
    }
}
