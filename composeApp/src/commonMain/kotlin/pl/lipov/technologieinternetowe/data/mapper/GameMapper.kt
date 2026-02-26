package pl.lipov.technologieinternetowe.data.mapper

import pl.lipov.technologieinternetowe.data.dto.GameDto
import pl.lipov.technologieinternetowe.domain.model.Game
import technologieinternetowe.composeapp.generated.resources.Res
import technologieinternetowe.composeapp.generated.resources.franko

fun GameDto.toGame() = Game(
    id = "$id",
    title = title,
    platforms = emptyList(),
    imageRes = Res.drawable.franko
)
