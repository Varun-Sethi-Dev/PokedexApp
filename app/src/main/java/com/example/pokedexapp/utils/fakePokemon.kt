package com.example.pokedexapp.utils

import com.example.pokedexapp.data.remote.responses.Animated
import com.example.pokedexapp.data.remote.responses.BlackWhite
import com.example.pokedexapp.data.remote.responses.Cries
import com.example.pokedexapp.data.remote.responses.Crystal
import com.example.pokedexapp.data.remote.responses.DiamondPearl
import com.example.pokedexapp.data.remote.responses.DreamWorld
import com.example.pokedexapp.data.remote.responses.Emerald
import com.example.pokedexapp.data.remote.responses.FireredLeafgreen
import com.example.pokedexapp.data.remote.responses.GenerationI
import com.example.pokedexapp.data.remote.responses.GenerationIi
import com.example.pokedexapp.data.remote.responses.GenerationIii
import com.example.pokedexapp.data.remote.responses.GenerationIv
import com.example.pokedexapp.data.remote.responses.GenerationV
import com.example.pokedexapp.data.remote.responses.GenerationVi
import com.example.pokedexapp.data.remote.responses.GenerationVii
import com.example.pokedexapp.data.remote.responses.GenerationViii
import com.example.pokedexapp.data.remote.responses.Gold
import com.example.pokedexapp.data.remote.responses.HeartgoldSoulsilver
import com.example.pokedexapp.data.remote.responses.Home
import com.example.pokedexapp.data.remote.responses.Icons
import com.example.pokedexapp.data.remote.responses.OfficialArtwork
import com.example.pokedexapp.data.remote.responses.OmegarubyAlphasapphire
import com.example.pokedexapp.data.remote.responses.Other
import com.example.pokedexapp.data.remote.responses.Platinum
import com.example.pokedexapp.data.remote.responses.Pokemon
import com.example.pokedexapp.data.remote.responses.RedBlue
import com.example.pokedexapp.data.remote.responses.RubySapphire
import com.example.pokedexapp.data.remote.responses.Showdown
import com.example.pokedexapp.data.remote.responses.Silver
import com.example.pokedexapp.data.remote.responses.Species
import com.example.pokedexapp.data.remote.responses.Sprites
import com.example.pokedexapp.data.remote.responses.Type
import com.example.pokedexapp.data.remote.responses.TypeX
import com.example.pokedexapp.data.remote.responses.UltraSunUltraMoon
import com.example.pokedexapp.data.remote.responses.Versions
import com.example.pokedexapp.data.remote.responses.XY
import com.example.pokedexapp.data.remote.responses.Yellow


val fakePokemon = Pokemon(
    abilities = listOf(),
    base_experience = 2,
    cries = Cries(latest = "", legacy = ""),
    forms = listOf(),
    game_indices = listOf(),
    height = 100,
    held_items = listOf(),
    id = 1,
    is_default = true,
    location_area_encounters = "",
    moves = listOf(),
    name = "",
    order = 2,
    past_abilities = listOf(),
    past_types = listOf(),
    species = Species("", ""),
    sprites = Sprites(
        "", "", "",
        "", "", "",
        "", "", Other(
            DreamWorld("", ""),
            Home("", "", "", ""),
            OfficialArtwork("", ""),
            Showdown(
                "", "", "",
                "", "", "", "", ""
            )
        ),
        Versions(
            GenerationI(
                RedBlue("", "", "", "", "", ""),
                Yellow("", "", "", "", "", "")
            ), GenerationIi(
                Crystal("", "", "", "", "", "", "", ""),
                Gold("", "", "", "", ""),
                Silver("", "", "", "", "")
            ), GenerationIii(
                Emerald("", ""), FireredLeafgreen("", "", "", ""),
                RubySapphire("", "", "", "")
            ), GenerationIv(
                DiamondPearl("", "", "", "", "", "", "", ""),
                HeartgoldSoulsilver("", "", "", "", "", "", "", ""),
                Platinum("", "", "", "", "", "", "", "")
            ), GenerationV(
                BlackWhite(
                    Animated(
                        "", "", "", "", "", "", "",
                        ""
                    ), "", "", "", "", "", "", "",
                    ""
                )
            ),
            GenerationVi(
                OmegarubyAlphasapphire("", "", "", ""),
                XY("", "", "", "")
            ),
            GenerationVii(
                Icons("", ""),
                UltraSunUltraMoon("", "", "", "")
            ), GenerationViii(
                Icons("", "")
            )
        )
    ),
    listOf(),
    types = listOf(
        Type(1, TypeX("normal", "")),
        Type(2, TypeX("fire", ""))
    ),
    340
)
