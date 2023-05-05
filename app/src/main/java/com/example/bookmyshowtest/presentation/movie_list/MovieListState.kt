package com.example.bookmyshowtest.presentation.movie_list

import com.example.bookmyshowtest.domain.model.Movie


data class MovieListState(
    val isLoading: Boolean = false,
    var movies: List<Movie>? = null,
    val error: String = "",
)
