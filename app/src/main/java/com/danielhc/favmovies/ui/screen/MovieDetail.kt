package com.danielhc.favmovies.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.danielhc.favmovies.helper.formatCurrency
import com.danielhc.favmovies.helper.loadPicture
import com.danielhc.favmovies.model.Movie
import com.danielhc.favmovies.ui.component.HeartButton

@Composable
fun MovieDetail(
    movie: Movie
){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val image = loadPicture(LocalContext.current, movie.artworkUrl100).value
            image?.let {
                Image(
                    bitmap = image.asImageBitmap(),
                    contentDescription = "",
                    modifier = Modifier
                        .width(80.dp)
                        .height(120.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = movie.trackName,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(text = movie.primaryGenreName)
                    Text(text = formatCurrency(movie.trackPrice))
                    Spacer(modifier = Modifier.height(6.dp))
                    HeartButton(isActive = false)
                }


            }

        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(text = movie.longDescription)
    }
        

}