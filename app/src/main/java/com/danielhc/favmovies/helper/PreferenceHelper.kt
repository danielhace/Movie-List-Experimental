package com.danielhc.favmovies.helper

import android.content.Context
import android.content.SharedPreferences

private const val prefName = "FavMoviesPref"

private fun getSharedPreference(context: Context): SharedPreferences {
    return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
}

fun saveStringPreference(context: Context, name: String, value: String){
    val prefs = getSharedPreference(context)
    with(prefs.edit()){
        putString(name, value)
        apply()
    }
}

fun getStringPreference(context: Context, name: String): String?{
    val prefs = getSharedPreference(context)
    return prefs.getString(name, "")
}