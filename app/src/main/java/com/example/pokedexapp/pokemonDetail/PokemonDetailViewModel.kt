package com.example.pokedexapp.pokemonDetail

import androidx.lifecycle.ViewModel
import com.example.pokedexapp.data.remote.responses.Pokemon
import com.example.pokedexapp.repository.NetworkPokemonRepository
import com.example.pokedexapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: NetworkPokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemon(pokemonName)
    }
}