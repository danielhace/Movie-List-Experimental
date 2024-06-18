package com.danielhc.favmovies.di

import android.content.Context
import com.danielhc.favmovies.network.IRetrofitService
import com.danielhc.favmovies.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        apiService: IRetrofitService,
        context: Context
    ): MovieRepository{
        return MovieRepository(apiService, context)
    }
}