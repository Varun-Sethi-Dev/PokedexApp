package com.example.pokedexapp.pokemonList

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toUpperCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.example.pokedexapp.models.PokedexListEntry
import com.example.pokedexapp.repository.NetworkPokemonRepository
import com.example.pokedexapp.utils.Constants.PAGE_SIZE
import com.example.pokedexapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(val repository: NetworkPokemonRepository) :
    ViewModel() {
    private var currPage = 0
    var isLoading by mutableStateOf(false)
    var pokemonList = mutableStateListOf<PokedexListEntry>()
    var loadError by mutableStateOf("")
    var endReached by mutableStateOf(false)

    init {
        loadPokemonPaginated()
    }

    fun loadPokemonPaginated() {
        viewModelScope.launch {
            isLoading = true
            val result = repository.getPokemonList(limit = PAGE_SIZE, offset = currPage * PAGE_SIZE)
            when (result) {
                is Resource.Success -> {
                    endReached = currPage * PAGE_SIZE >= result.data!!.count
                    val pokeDexEntries = result.data.results.mapIndexed { index, entry ->
                        val number = if (entry.url.endsWith("/")) {
                            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            entry.url.takeLastWhile { it.isDigit() }
                        }

                        val url =
                            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
                        PokedexListEntry(
                            pokemonName = entry.name.uppercase(locale = Locale.ROOT),
                            imageUrl = url,
                            number = number.toInt()
                        )
                    }
                    currPage++
                    loadError = ""
                    isLoading = false
                    pokemonList += pokeDexEntries

                }
                /*is Resource.Loading -> {}
                This code for loading is  not required here because we are doing it with our
                isLoading var for loading logic
                * */

                is Resource.Error -> {
                    loadError = result.message!!
                    isLoading = false
                }

            }
        }
    }

    fun calcDominantColor(
        drawable: Drawable,
        onFinish: (Color) -> Unit
    ) {
        //To cast drawable to bitmap bec pallet only uses bitmap also to change the config bec palette work with a specific format
        // and we don't know that format for the image from network
        val bitmap = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bitmap).generate() { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }
}