package com.example.pokedexapp.utils

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)

    class Loading<T>(data: T? = null) : Resource<T>(data)
    /* This is not needed in our this project bec. we are handling loading logic within the
    * viewModel
    * */

    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}
/* This is the sealed class which is used to wrap the data that we get from the api and
* also to handle the different states of the data like loading, error, success.
* In this the success state does not message and even the data is not null, the loading state does not have message
* but its data is nullable and the error state has message asa must given parameter and its data is nullable.
* We will usually emit the loading state first and then change according to its data value if null then error else success
*/