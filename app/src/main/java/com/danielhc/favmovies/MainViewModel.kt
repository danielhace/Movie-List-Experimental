package com.danielhc.favmovies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielhc.favmovies.model.Movie
import com.danielhc.favmovies.model.response.ApiResponse
import com.danielhc.favmovies.network.state.ApiState
import com.danielhc.favmovies.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel(){
    private val _movies = mutableStateOf<ApiState<ApiResponse<Movie>>>(ApiState.Loading)
    val movies: State<ApiState<ApiResponse<Movie>>> = _movies

    private val _query = mutableStateOf("Star")
    val query: State<String> = _query

    init {
        searchMovie()
    }

    fun searchMovie(){
        viewModelScope.launch {
            try {
                val response = movieRepository.getMovie(_query.value)
                _movies.value = ApiState.Success(response)
            } catch (e: Exception) {
                _movies.value = ApiState.Error("Failed to fetch data")
            }
        }
    }

    fun onQueryChanged(newQuery: String){
        _query.value = newQuery
    }

    fun saveMovieForNavigation(movie: Movie){
        movieRepository.saveCurrentMovie(movie)
    }
}