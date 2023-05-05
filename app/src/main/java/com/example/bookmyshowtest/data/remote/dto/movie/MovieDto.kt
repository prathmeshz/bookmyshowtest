package com.example.bookmyshowtest.data.remote.dto.movie

import com.example.bookmyshowtest.domain.model.Movie

data class MovieDto(
    val dates: Dates,
    val page: Int,
    val results: List<com.example.bookmyshowtest.data.remote.dto.movie.Movie>,
    val total_pages: Int,
    val total_results: Int
)

fun MovieDto.toMovies(): List<com.example.bookmyshowtest.domain.model.Movie> {
    return results.map {
        Movie(
            id = it.id,
            poster_path = it.poster_path,
            release_date = it.release_date,
            title = it.title
        )
    }
}