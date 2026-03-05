package pl.lipov.technologieinternetowe.data.mapper

import pl.lipov.technologieinternetowe.data.dto.GameDto
import pl.lipov.technologieinternetowe.domain.model.Game

fun GameDto.toGame() = Game(
    id = id,
    title = title,
    gameUrl = gameUrl,
    gogUrl = gogUrl,
    steamUrl = steamUrl,
    playable = playable
)
