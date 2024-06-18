package com.danielhc.favmovies.repository

import android.content.Context
import android.util.Log
import com.danielhc.favmovies.helper.getStringPreference
import com.danielhc.favmovies.helper.saveStringPreference
import com.danielhc.favmovies.model.Movie
import com.danielhc.favmovies.model.response.ApiResponse
import com.danielhc.favmovies.network.IRetrofitService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository

@Inject
constructor(
    private val apiService: IRetrofitService,
    private val context: Context
){

    suspend fun getMovie(keyword: String): ApiResponse<Movie>{
        return apiService.searchMovie(keyword)
    }

    fun saveCurrentMovie(movie: Movie){
        val movieJson = Gson().toJson(movie)
        saveStringPreference(context, "currentMovie", movieJson)
    }

    fun getCurrentMovie(): Movie?{
        getStringPreference(context, "currentMovie")?.let {
            Log.d("FOOD String", it)
            val type = object : TypeToken<Movie>(){}.type
            return Gson().fromJson<Movie>(it, type)

        } ?: run{
            return null
        }
    }
}