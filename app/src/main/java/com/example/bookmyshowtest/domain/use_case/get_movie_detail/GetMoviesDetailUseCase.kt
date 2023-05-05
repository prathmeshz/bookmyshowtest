package com.example.bookmyshowtest.domain.use_case.get_movie_detail

import com.example.bookmyshowtest.common.Response
import com.example.bookmyshowtest.data.remote.dto.movie.toMovies
import com.example.bookmyshowtest.data.remote.dto.movie_detail.toMoviesDetail
import com.example.bookmyshowtest.domain.model.Movie
import com.example.bookmyshowtest.domain.model.MovieDetail
import com.example.bookmyshowtest.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMoviesDetailUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(movieId: String): Flow<Response<MovieDetail>> = flow {
        try {
            emit(Response.Loading())
            val movieDetail = repository.getMovieById(movieId);
            emit(Response.Success<MovieDetail>(movieDetail.toMoviesDetail()))
        } catch (e: HttpException) {
            emit(Response.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Response.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}