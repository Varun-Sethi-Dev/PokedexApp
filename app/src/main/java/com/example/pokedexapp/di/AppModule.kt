package com.example.pokedexapp.di

import com.example.pokedexapp.data.remote.PokeApi
import com.example.pokedexapp.repository.NetworkPokemonRepository
import com.example.pokedexapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNetworkPokemonRepository(api: PokeApi): NetworkPokemonRepository =
        NetworkPokemonRepository(api)

    @Singleton
    @Provides
    fun providePokemonApi(): PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }
}
/*For DI using hilt we need to create module and annotate it as @Module also annotate it with @InstallIn
* and specify the component to which we will install it. This module will be used to receive the instances
* of the values that we want to inject.
* @Module annotation is used to mark a class or object that defines how objects are provided
* (created and managed) within your application. It essentially acts as a blueprint for Hilt
*  to understand how to provide dependencies for other parts of your code. */