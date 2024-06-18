package com.danielhc.favmovies

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.danielhc.favmovies.network.state.ApiState
import com.danielhc.favmovies.ui.screen.MovieList
import com.danielhc.favmovies.ui.theme.FavMoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current;

            val moviesState = viewModel.movies.value
            val query = viewModel.query.value

            FavMoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when(moviesState){
                        is ApiState.Loading -> {
                            CircularProgressIndicator(
                                modifier = Modifier.then(Modifier.size(32.dp))
                            )
                        }
                        is ApiState.Success -> {
                            val moviesResponse = moviesState.data
                            MovieList(
                                moviesResponse.results,
                                query,
                                { newValue ->
                                    viewModel.onQueryChanged(newValue)
                                },
                                {
                                    viewModel.searchMovie()
                                },
                                { movie ->
                                    val intent = Intent(context, MovieDetailActivity::class.java)
                                    intent.putExtra("movie", movie)
                                    startActivity(intent)
                                }
                            )
                        }
                        is ApiState.Error -> {
                            Text(text = "Error")
                        }
                    }
                }
            }
        }

    }
}