package pl.lipov.server

import kotlinx.serialization.Serializable

@Serializable
enum class Platform {
    ATARI,
    AMIGA,
    SNES,
    MEGA_DRIVE,
    DOS,
    WIN95,
    GOG,
    STEAM,
    BATTLE_NET
}
