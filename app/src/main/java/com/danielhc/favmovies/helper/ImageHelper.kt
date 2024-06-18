package com.danielhc.favmovies.helper

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.danielhc.favmovies.R

fun loadPicture(
    context: Context,
    url: String,
): MutableState<Bitmap?>{

    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(context)
        .asBitmap()
        .load(R.drawable.default_placeholder)
        .into(object : CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }

        })

    Glide.with(context)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }

        })

    return bitmapState
}

fun loadPicture(
    context: Context,
    resource: Int,
): MutableState<Bitmap?>{

    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(context)
        .asBitmap()
        .load(resource)
        .into(object : CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }

        })

    return bitmapState
}