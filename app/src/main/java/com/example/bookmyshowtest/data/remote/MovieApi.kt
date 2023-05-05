package com.example.bookmyshowtest.data.remote

import com.example.bookmyshowtest.common.Constants
import com.example.bookmyshowtest.data.remote.dto.movie.MovieDto
import com.example.bookmyshowtest.data.remote.dto.movie_detail.MovieDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("movie/now_playing?api_key=${Constants.API_KEY}")
    suspend fun getMovies(): MovieDto

    @GET("movie/{movie_id}?api_key=${Constants.API_KEY}")
    suspend fun getMovieById(@Path("movie_id") movieId: String): MovieDetailDto
}