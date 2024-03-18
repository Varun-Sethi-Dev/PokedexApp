<h1 align="center">Pokedex</h1>


<p align="center">  
🗡️ Pokedex demonstrates modern Android development with Hilt, Coroutines, Flow, Jetpack (ViewModel), and Material 3 Design based on MVVM architecture.
</p>
</br>

<p align="center">
<img src="/preview/screenshot.png"/>
</p>

## Download
Go to the [Releases](https://github.com/Varun-Sethi-Dev/PokedexApp/releases/tag/release) to download the latest APK.

<img src="/preview/preview.gif" align="right" width="320"/>
## Tech stack & Open-source libraries
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- Jetpack
  - Lifecycle: Observe Android lifecycles and handle UI states upon the lifecycle changes.
  - ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
  - DataBinding: Binds UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
  - [Hilt](https://dagger.dev/hilt/): for dependency injection.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository Pattern

- [kapt](https://kotlinlang.org/docs/kapt.html): Kotlin Annotation Processing Tool


- [Coil]([https://github.com/bumptech/glide](https://coil-kt.github.io/coil/)):Loading images from network.
- [Palette]([https://github.com/florent37/GlidePalette](https://developer.android.com/develop/ui/views/graphics/palette-colors)): For determining dominant colour 
- [Timber](https://github.com/JakeWharton/timber): A logger with a small, extensible API.

## Architecture
**Pokedex** is based on the MVVM architecture and the Repository pattern, which follows the [Google's official architecture guidance](https://developer.android.com/topic/architecture).

![architecture](figure/figure0.png)

The overall architecture of **Pokedex** is composed of two layers; the UI layer and the data layer. Each layer has dedicated components and they have each different responsibilities, as defined below:

**Pokedex** was built with [Guide to app architecture](https://developer.android.com/topic/architecture), so it would be a great sample to show how the architecture works in real-world projects.


### Architecture Overview

![architecture](figure/figure1.png)

- Each layer follows [unidirectional event/data flow](https://developer.android.com/topic/architecture/ui-layer#udf); the UI layer emits user events to the data layer, and the data layer exposes data as a stream to other layers.
- The data layer is designed to work independently from other layers and must be pure, which means it doesn't have any dependencies on the other layers.

With this loosely coupled architecture, you can increase the reusability of components and scalability of your app.

### UI Layer

![architecture](figure/figure2.png)

The UI layer consists of UI elements to configure screens that could interact with users and [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that holds app states and restores data when configuration changes.

For more information, check out the [Guide to Android app modularization](https://developer.android.com/topic/modularization).


## Open API

<img src="https://user-images.githubusercontent.com/24237865/83422649-d1b1d980-a464-11ea-8c91-a24fdf89cd6b.png" align="right" width="21%"/>

Pokedex using the [PokeAPI](https://pokeapi.co/) for constructing RESTful API.<br>
PokeAPI provides a RESTful API interface to highly detailed objects built from thousands of lines of data related to Pokémon.
