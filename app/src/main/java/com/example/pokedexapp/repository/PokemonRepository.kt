package com.example.pokedexapp.repository

import com.example.pokedexapp.data.remote.responses.Pokemon
import com.example.pokedexapp.data.remote.responses.PokemonList
import com.example.pokedexapp.utils.Resource

interface PokemonRepository {
    suspend fun getPokemonList(
        limit: Int, offset: Int
    ): Resource<PokemonList>

    suspend fun getPokemon(
        name: String
    ): Resource<Pokemon>
}
/* This is the repository interface which will be used to get the data from the api and will be used to
 * provide the data to the view-model.
 * Actually we make this interface mirroring the methods in PokeApi we usually make this interface this for
 * better testing to create a fake api even our final repository would be implementing the
 * this interface  */