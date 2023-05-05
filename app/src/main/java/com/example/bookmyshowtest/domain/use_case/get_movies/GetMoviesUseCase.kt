package com.example.bookmyshowtest.domain.use_case.get_movies

import com.example.bookmyshowtest.common.Response
import com.example.bookmyshowtest.data.remote.dto.movie.toMovies
import com.example.bookmyshowtest.domain.model.Movie
import com.example.bookmyshowtest.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(): Flow<Response<List<Movie>>> = flow {
        try {
            emit(Response.Loading<List<Movie>>())
            val coins = repository.getMovies()
            emit(Response.Success<List<Movie>>(coins.toMovies()))
        } catch (e: HttpException) {
            emit(Response.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Response.Error("Couldn't reach server. Check your internet connection."))
        }
    }


}