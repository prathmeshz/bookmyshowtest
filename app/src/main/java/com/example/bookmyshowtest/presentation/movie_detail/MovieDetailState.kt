package com.example.bookmyshowtest.presentation.movie_detail

import com.example.bookmyshowtest.domain.model.Movie
import com.example.bookmyshowtest.domain.model.MovieDetail


data class MovieDetailState(
    val isLoading: Boolean = false,
    var movie: MovieDetail? = null,
    val error: String = "",
)
