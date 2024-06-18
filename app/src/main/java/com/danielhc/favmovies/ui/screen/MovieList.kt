package com.danielhc.favmovies.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.danielhc.favmovies.model.Movie
import com.danielhc.favmovies.ui.component.MovieCard
import kotlinx.coroutines.delay

@Composable
fun MovieList(
    movies: List<Movie>,
    query: String,
    onChangedQuery: (String) -> Unit,
    onSearchExecute: () -> Unit,
    onClickItem: (Movie) -> Unit
){
    Column {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = query,
                onValueChange = { newValue ->
                    onChangedQuery(newValue)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null
                    )
                }
            )
            
            LaunchedEffect(key1 = query){

                delay(1000)
                onSearchExecute()
            }
        }
        LazyColumn{
            itemsIndexed(
                items = movies
            ){ _, movie ->
                MovieCard(movie = movie) {
                    onClickItem(movie)
                }
            }
        }
    }

}