package pl.lipov.server

object GamesRepository {

    val games = listOf(
        Game("river_raid", "River Raid (1982)", platform = Platform.ATARI, playable = true),
        Game("boulder_dash", "Boulder Dash (1984)", platform = Platform.ATARI, playable = true),
        Game(
            "commander_keen_complete_pack", "Commander Keen (1990)",
            gameUrl = "https://www.gog.com/pl/game/commander_keen_complete_pack",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "miecze_valdgira", "Miecze Valdgira (1991)",
            platform = Platform.ATARI, playable = true, completed = true
        ),

        Game(
            "james_pond_2", "James Pond 2 (1991)",
            platform = Platform.AMIGA, playable = true
        ),

        Game(
            "flashback", "Flashback (1992)",
            gameUrl = "https://www.gog.com/pl/game/flashback",
            platform = Platform.GOG, playable = true, completed = true
        ),

        Game(
            "wolfenstein_3d", "Wolfenstein 3D (1992)",
            gameUrl = "https://www.gog.com/pl/game/wolfenstein_3d",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "indiana_jones_and_the_fate_of_atlantis",
            "Indiana Jones and the Fate of Atlantis (1992)",
            gameUrl = "https://store.steampowered.com/app/6010/Indiana_Jones_and_the_Fate_of_Atlantis",
            platform = Platform.STEAM, completed = true
        ),

        Game(
            "mortal_kombat", "Mortal Kombat (1992)",
            gameUrl = "https://www.gog.com/pl/game/mortal_kombat_123",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "lionheart", "Lionheart (1993)",
            platform = Platform.AMIGA, playable = true
        ),

        Game(
            "superfrog", "Superfrog (1993)",
            platform = Platform.AMIGA, playable = true, completed = true
        ),

        Game(
            "traps_treasures", "Traps 'n' Treasures (1993)",
            platform = Platform.AMIGA, playable = true
        ),

        Game(
            "qwak", "Qwak (1993)",
            platform = Platform.AMIGA, playable = true
        ),

        Game(
            "prehistorik_2", "Prehistorik 2 (1993)",
            gameUrl = "https://www.gog.com/pl/game/prehistorik_12",
            platform = Platform.GOG, playable = true, completed = true
        ),

        Game(
            "doom", "DOOM (1993)",
            gameUrl = "https://www.gog.com/pl/game/doom_doom_ii",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "ruff_tumble", "Ruff 'n' Tumble (1994)",
            platform = Platform.AMIGA, playable = true
        ),

        Game(
            "zool_2", "Zool 2 (1994)",
            platform = Platform.AMIGA, playable = true
        ),

        Game(
            "franko", "Franko: The Crazy Revenge (1994)",
            platform = Platform.DOS, playable = true
        ),

        Game(
            "beneath_a_steel_sky", "Beneath a Steel Sky (1994)",
            gameUrl = "https://www.gog.com/pl/game/beneath_a_steel_sky",
            platform = Platform.GOG, playable = true, completed = true
        ),

        Game(
            "earthworm_jim", "Earthworm Jim (1994)",
            gameUrl = "https://www.gog.com/pl/game/earthworm_jim",
            platform = Platform.GOG, completed = true
        ),

        Game(
            "screamer", "Screamer (1995)",
            gameUrl = "https://www.gog.com/pl/game/screamer",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "tyrian", "Tyrian (1995)",
            gameUrl = "https://www.gog.com/pl/game/tyrian_2000",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "teenagent", "Teenagent (1995)",
            gameUrl = "https://www.gog.com/pl/game/teenagent",
            platform = Platform.GOG, playable = true, completed = true
        ),

        Game(
            "flight_of_the_amazon_queen", "Flight of the Amazon Queen (1995)",
            gameUrl = "https://www.gog.com/pl/game/flight_of_the_amazon_queen",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "star_wars_dark_forces", "STAR WARS Dark Forces (1995)",
            gameUrl = "https://www.gog.com/pl/game/star_wars_dark_forces",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "rayman", "Rayman (1995)",
            gameUrl = "https://www.gog.com/pl/game/rayman_forever",
            platform = Platform.GOG, playable = true, completed = true
        ),

        Game(
            "donkey_kong_country_2",
            "Donkey Kong Country 2: Diddy's Kong Quest (1995)",
            platform = Platform.SNES, playable = true
        ),

        Game(
            "fire_fight", "Fire Fight (1996)",
            platform = Platform.WIN95, playable = true
        ),

        Game(
            "skaut", "Skaut Kwatemaster (1996)",
            platform = Platform.WIN95, playable = true
        ),

        Game(
            "resident_evil", "Resident Evil (1996)",
            gameUrl = "https://www.gog.com/pl/game/resident_evil",
            platform = Platform.GOG
        ),

        Game(
            "tomb_raider", "Tomb Raider (1996)",
            gameUrl = "https://www.gog.com/pl/game/tomb_raider_i_to_iii_remastered",
            platform = Platform.GOG, playable = true, completed = true
        ),

        Game(
            "moto_racer", "Moto Racer (1997)",
            gameUrl = "https://www.gog.com/pl/game/moto_racer",
            platform = Platform.GOG, playable = true, completed = true
        ),

        Game(
            "lew_leon", "Zagadki Lwa Leona (1998)",
            gameUrl = "https://www.gog.com/pl/game/leo_the_lions_puzzles",
            platform = Platform.GOG, playable = true, completed = true
        ),

        Game(
            "jazz_jackrabbit_2", "Jazz Jackrabbit 2 (1998)",
            gameUrl = "https://www.gog.com/pl/game/jazz_jackrabbit_2_collection",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "starcraft", "StarCraft (1998)",
            gameUrl = "https://eu.shop.battle.net/en-us/product/starcraft-remastered",
            platform = Platform.BATTLE_NET, completed = true
        ),

        Game(
            "colin", "Colin McRae Rally (1998)",
            platform = Platform.WIN95, playable = true
        ),

        Game(
            "nfs3", "Need for Speed III: Hot Pursuit (1998)",
            platform = Platform.WIN95, playable = true
        ),

        Game(
            "half_life", "Half-Life (1998)",
            gameUrl = "https://store.steampowered.com/app/70/HalfLife/",
            platform = Platform.STEAM, completed = true
        ),

        Game(
            "rollercoaster_tycoon", "RollerCoaster Tycoon (1999)",
            gameUrl = "https://www.gog.com/pl/game/rollercoaster_tycoon_deluxe",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "kao", "Kangurek Kao (2000)",
            gameUrl = "https://www.gog.com/pl/game/kao_the_kangaroo_trilogy",
            platform = Platform.GOG
        ),

        Game(
            "dino_crisis_2", "Dino Crisis 2",
            gameUrl = "https://www.gog.com/pl/game/dino_crisis_2",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "aliens_versus_predator",
            "Aliens versus Predator Classic 2000 (2000)",
            gameUrl = "https://www.gog.com/pl/game/aliens_versus_predator_classic_2000",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "red_faction", "Red Faction (2001)",
            gameUrl = "https://www.gog.com/pl/game/red_faction",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "max_payne", "Max Payne (2001)",
            gameUrl = "https://store.steampowered.com/app/12140/Max_Payne/",
            platform = Platform.STEAM, completed = true
        ),

        Game(
            "star_wars_galactic_battlegrounds",
            "STAR WARS Galactic Battlegrounds Saga (2001)",
            gameUrl = "https://www.gog.com/pl/game/star_wars_galactic_battlegrounds_saga",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "medal_of_honor", "Medal of Honor (2002)",
            gameUrl = "https://www.gog.com/pl/game/medal_of_honor_allied_assault_war_chest",
            platform = Platform.GOG, playable = true, completed = true
        ),

        Game(
            "prince_of_persia",
            "Prince of Persia: The Sands of Time (2003)",
            gameUrl = "https://www.gog.com/pl/game/prince_of_persia_the_sands_of_time",
            platform = Platform.GOG
        ),

        Game(
            "far_cry", "Far Cry (2004)",
            gameUrl = "https://www.gog.com/pl/game/far_cry",
            platform = Platform.GOG
        ),

        Game(
            "painkiller", "Painkiller (2004)",
            gameUrl = "https://www.gog.com/pl/game/painkiller",
            platform = Platform.GOG
        ),

        Game(
            "fear", "F.E.A.R. (2005)",
            gameUrl = "https://www.gog.com/pl/game/fear_platinum",
            platform = Platform.GOG
        ),

        Game(
            "gta4", "Grand Theft Auto IV (2008)",
            gameUrl = "https://store.steampowered.com/app/12210/Grand_Theft_Auto_IV_The_Complete_Edition/",
            platform = Platform.STEAM
        ),

        Game(
            "streets_of_rage_4", "Streets of Rage 4 (2020)",
            gameUrl = "https://www.gog.com/pl/game/streets_of_rage_4",
            platform = Platform.GOG, playable = true
        ),

        Game(
            "robo_cop", "RoboCop: Rogue City (2023)",
            gameUrl = "https://store.steampowered.com/app/1681430/RoboCop_Rogue_City/",
            platform = Platform.STEAM
        ),

        Game(
            "tony", "Tony: Montezuma’s Gold (2024)",
            platform = Platform.ATARI, playable = true
        ),

        Game(
            "ski_jumping_world_cup", "Ski Jumping World Cup (2025)",
            gameUrl = "https://www.gog.com/pl/game/ski_jumping_world_cup",
            platform = Platform.GOG, playable = true
        )
    )
}