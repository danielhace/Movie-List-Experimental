package com.danielhc.favmovies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.danielhc.favmovies.model.Movie
import com.danielhc.favmovies.model.response.ApiResponse
import com.danielhc.favmovies.network.state.ApiState
import com.danielhc.favmovies.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel(){

    private val _movie = mutableStateOf<Movie?>(null)
    val movie: State<Movie?> = _movie
}