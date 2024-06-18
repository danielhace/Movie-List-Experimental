package com.danielhc.favmovies.network

import com.danielhc.favmovies.model.Movie
import com.danielhc.favmovies.model.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofitService {

    @GET("search?media=movie&country=au")
    suspend fun searchMovie(@Query("term") keyword: String): ApiResponse<Movie>

}