package com.example.bookmyshowtest.di

import com.example.bookmyshowtest.common.Constants
import com.example.bookmyshowtest.data.repository.MoviesRepositoryImpl
import com.example.bookmyshowtest.domain.repository.MoviesRepository
import com.example.bookmyshowtest.data.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): MovieApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi): MoviesRepository {
        return MoviesRepositoryImpl(api)
    }
}