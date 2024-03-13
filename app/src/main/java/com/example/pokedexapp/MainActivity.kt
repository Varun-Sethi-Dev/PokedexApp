package com.example.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedexapp.data.remote.responses.PokemonList
import com.example.pokedexapp.pokemonDetail.PokemonDetailScreen
import com.example.pokedexapp.pokemonList.PokemonListScreen
import com.example.pokedexapp.ui.theme.PokedexAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint//Using hilt for dependency injection and marking the activity as entry point
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexAppTheme {
                val navController = rememberNavController()
                /*first building up the navigation component of our app in which we have
                * 2 screens one displays the list and other for the detail view we are also passing
                * 2 parameters while navigating from the list screen on tap of a pokemon. */
                NavHost(navController = navController, startDestination = "pokemon_list_screen") {
                    composable("pokemon_list_screen") {
                        PokemonListScreen(navController = navController)
                    }
                    composable(
                        "pokemon_detail_screen/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument(name = "dominantColor", builder = {
                                type = NavType.IntType
                            }),
                            navArgument(name = "pokemonName", builder = {
                                type = NavType.StringType
                            })
                        )
                    ) { navBackStackEntry ->
                        val dominantColor = remember {
                            val color = navBackStackEntry.arguments?.getInt("dominantColor")
                            color?.let {
                                Color(it)
                            } ?: Color.White
                        }
                        val pokemonName = remember {
                            navBackStackEntry.arguments?.getString("pokemonName")
                                ?: "No Name Null Case"
                        }
                        PokemonDetailScreen(
                            dominantColor,
                            pokemonName,
                            navController = navController
                        )
                    }
                }

            }
        }
    }
}

