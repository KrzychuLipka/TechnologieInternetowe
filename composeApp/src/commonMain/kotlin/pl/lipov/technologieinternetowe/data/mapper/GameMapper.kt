package pl.lipov.technologieinternetowe.data.mapper

import pl.lipov.technologieinternetowe.data.dto.GameDto
import pl.lipov.technologieinternetowe.domain.model.Game

private const val MAGAZINE_NUMBER = 9

fun GameDto.toGame() = Game(
    id = id,
    title = title,
    magazineNumber = MAGAZINE_NUMBER,
    platform = platform,
    gameUrl = gameUrl,
    playable = playable,
    completed = completed
)