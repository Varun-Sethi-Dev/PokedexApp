package com.example.pokedexapp.pokemonList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedexapp.R
import com.example.pokedexapp.models.PokedexListEntry
import com.example.pokedexapp.ui.theme.RobotoCondensed

@Composable
fun PokemonListScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
                contentDescription = "Pokemon Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)

            )/*
    var textState by remember { mutableStateOf("") }
            TextField(
                value = textState, onValueChange = { textState = it },
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .shadow(5.dp, shape = CircleShape),
                shape = CircleShape,
                maxLines = 1,
                singleLine = true,
                colors =
                TextFieldDefaults.colors(
                    disabledContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    errorContainerColor = Color.White
                ),
                placeholder = {
                    Text(
                        text = "Search...",
                        color = Color.LightGray,
                        style = TextStyle(Color.Black),
                    )
                }
            )
            */
            // this is a normal text field
            //OutlinedTextField(value = "Search...", onValueChange = {})
            // this is an outlined text field which is a material design component
            //But for out custom text field we will implement it by BasicTextField

            SearchBar(hint = "Search...", modifier = Modifier.padding(16.dp), onSearch = {
                //Network request
            })
            Spacer(modifier = Modifier.height(16.dp))
            PokeDexGridScreen(navController = navController)

        }

    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier, hint: String = "", onSearch: (String) -> Unit
) {
    var textState by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(hint != "") }
    Box(modifier = modifier) {
        BasicTextField(value = textState,
            onValueChange = {
                textState = it
                onSearch(it)
            },
            textStyle = TextStyle(color = Color.Black),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White, shape = CircleShape
                )
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged { focusState ->
                    isHintDisplayed = !focusState.isFocused
                })
        if (isHintDisplayed) {
            Text(
                text = hint,
                style = TextStyle(Color.Black),
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 20.dp)
            )
        }
    }
}

@Composable
fun PokemonEntry(
    entry: PokedexListEntry,
    navController: NavController,
    modifier: Modifier = Modifier,
    pokemonListViewModel: PokemonListViewModel = hiltViewModel<PokemonListViewModel>()
) {
    val defaultDominantColor = MaterialTheme.colorScheme.surface
    var dominantColorState by remember {
        mutableStateOf(defaultDominantColor)
    }
    Box(contentAlignment = Alignment.Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(
                Brush.verticalGradient(
                    listOf(dominantColorState, defaultDominantColor)
                )
            )
            .aspectRatio(1f)
            .clickable {
                navController.navigate(route = "pokemon_detail_screen/${dominantColorState.toArgb()}/${entry.pokemonName}")
            }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = entry.imageUrl)
                    .crossfade(true)
//                    .target { drawable ->
//                        pokemonListViewModel.calcDominantColor(
//                            drawable = drawable,
//                            onFinish = { color ->
//                                dominantColorState = color
//                            }
//                        )
//                    }
                    .build(),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentDescription = "Image of ${entry.pokemonName}",
                modifier = Modifier.size(120.dp)
            )
            val context = LocalContext.current
           // val imageLoader = ImageLoader(context) // Get the ImageLoader instance

           // val result = imageLoader()
            Text(
                text = entry.pokemonName,
                textAlign = TextAlign.Center,
                fontFamily = RobotoCondensed,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun PokeDexGridScreen(
    modifier: Modifier = Modifier,
    pokemonListViewModel: PokemonListViewModel = hiltViewModel<PokemonListViewModel>(),
    navController: NavController
) {
    val pokemonList = remember { pokemonListViewModel.pokemonList }
    val isLoading = remember { pokemonListViewModel.isLoading }
    val loadError = remember { pokemonListViewModel.loadError }
    val endReached = remember { pokemonListViewModel.endReached }
    LazyVerticalGrid(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        columns = GridCells.Fixed(count = 2),
        content = {
            items(pokemonList) { pokemonEntry ->
                if (!endReached) {
                    PokemonEntry(
                        entry = pokemonEntry,
                        navController = navController,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
        if (loadError.isNotEmpty()) {
            RetrySection(error = loadError) {
                pokemonListViewModel.loadPokemonPaginated()
            }
        }
    }
}

@Composable
fun RetrySection(
    error: String,
    onRetry: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = error, color = Color.Red, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onRetry() }) {
            Text(text = "Retry")
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewPokemonListScreen() {
    //PokemonListScreen(navController = )
}