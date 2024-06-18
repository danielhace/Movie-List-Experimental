package com.danielhc.favmovies.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.danielhc.favmovies.R
import com.danielhc.favmovies.helper.loadPicture

object HeartAnimationDefinition{

    enum class HeartButtonState{
        IDLE, ACTIVE
    }


    private val idleIconSize = 25.dp
    private val extendedIconSize = 30.dp
}

@Composable
fun HeartButton(
    isActive: Boolean
) {

    var icon = R.drawable.heart_grey
    if(isActive){
        icon = R.drawable.heart_red
    }
    loadPicture(LocalContext.current, icon).value?.let { image ->
        Image(
            bitmap = image.asImageBitmap(),
            contentDescription = "",
            modifier = Modifier
                .width(24.dp)
                .height(24.dp),
            contentScale = ContentScale.Fit
        )
    }

}