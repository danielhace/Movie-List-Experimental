package com.danielhc.favmovies.network.state

sealed class ApiState<out T : Any> {
    data class Success<out T : Any>(val data: T) : ApiState<T>()
    data class Error(val errorMessage: String) : ApiState<Nothing>()
    data object Loading : ApiState<Nothing>()
}