package com.example.bookmyshowtest.domain.repository

import com.example.bookmyshowtest.data.remote.dto.movie.MovieDto
import com.example.bookmyshowtest.data.remote.dto.movie_detail.MovieDetailDto

interface MoviesRepository {

    suspend fun getMovies(): MovieDto

    suspend fun getMovieById(movieId: String): MovieDetailDto
}