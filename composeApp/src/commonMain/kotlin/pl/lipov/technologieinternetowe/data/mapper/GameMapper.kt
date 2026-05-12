package pl.lipov.technologieinternetowe.data.mapper

import pl.lipov.technologieinternetowe.data.dto.GameDto
import pl.lipov.technologieinternetowe.domain.model.Game

fun GameDto.toGame() = Game(
    id = id,
    title = title,
    platform = platform,
    gameUrl = gameUrl,
    completed = completed
)