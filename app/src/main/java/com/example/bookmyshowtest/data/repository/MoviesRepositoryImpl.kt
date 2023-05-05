package com.example.bookmyshowtest.data.repository

import com.example.bookmyshowtest.domain.repository.MoviesRepository
import com.example.bookmyshowtest.data.remote.MovieApi
import com.example.bookmyshowtest.data.remote.dto.movie.MovieDto
import com.example.bookmyshowtest.data.remote.dto.movie_detail.MovieDetailDto
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val api: MovieApi
) : MoviesRepository {

    override suspend fun getMovies(): MovieDto {
        return api.getMovies()
    }

    override suspend fun getMovieById(movieId: String): MovieDetailDto {
        return api.getMovieById(movieId)
    }

}