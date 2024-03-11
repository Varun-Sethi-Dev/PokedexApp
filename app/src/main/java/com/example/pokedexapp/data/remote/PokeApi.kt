package com.example.pokedexapp.data.remote

import com.example.pokedexapp.data.remote.responses.Pokemon
import com.example.pokedexapp.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET(value = "pokemon")
    suspend fun getPokemonList(
        @Query(value = "limit") limit: Int,
        @Query(value = "offset") offset: Int
    ): PokemonList

    @GET(value = "pokemon/{name}")
    suspend fun getPokemon(
        @Path(value = "name") name: String
    ): Pokemon
}
/*This interface acts as mentioning methods that we are going to use to receive data from api.
* The actual working of these will be done via the retrofit
* In this we will make suspend fun for async. tasks */