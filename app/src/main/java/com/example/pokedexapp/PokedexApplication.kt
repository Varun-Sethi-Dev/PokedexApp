package com.example.pokedexapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class PokedexApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(tree = Timber.DebugTree())
    }
}
/*For DI we first create an application class which extends from the application class
* abd overriding the onCreate with Timber for logging.*/