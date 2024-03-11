package com.example.pokedexapp.repository

import com.example.pokedexapp.data.remote.PokeApi
import com.example.pokedexapp.data.remote.responses.Pokemon
import com.example.pokedexapp.data.remote.responses.PokemonList
import com.example.pokedexapp.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class NetworkPokemonRepository @Inject constructor(
    private val api: PokeApi
) : PokemonRepository {
    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(message = "An error occurred")
        }
        return Resource.Success(data = response)
    }

    override suspend fun getPokemon(name: String): Resource<Pokemon> {
        val response = try {
            api.getPokemon(name)
        } catch (e: Exception) {
            return Resource.Error(message = "An error occurred")
        }
        return Resource.Success(data = response)
    }
}

/*This is the actual repository class which will be used to get the data from the api and will be used to
* provide the data to the view-model.
* This class is annotated with @Inject to tell hilt that this class is injectable and it will be provided
* by the AppModule and also annotated with the @ActivityScoped in which it will live as long as the activity will.*/