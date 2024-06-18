package com.danielhc.favmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danielhc.favmovies.model.Movie
import com.danielhc.favmovies.ui.screen.MovieDetail
import com.danielhc.favmovies.ui.theme.FavMoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailActivity : ComponentActivity() {

    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movie = intent.getSerializableExtra("movie") as Movie

        setContent {
            FavMoviesTheme {
                // A surface container using the 'background' color from the theme
                MovieDetail(movie = movie)

            }
        }
    }
}