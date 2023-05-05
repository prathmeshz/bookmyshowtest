package com.example.bookmyshowtest.data.remote.dto.movie_detail

import com.example.bookmyshowtest.data.remote.dto.movie.MovieDto
import com.example.bookmyshowtest.domain.model.Movie
import com.example.bookmyshowtest.domain.model.MovieDetail

data class MovieDetailDto(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun MovieDetailDto.toMoviesDetail(): MovieDetail {
    return MovieDetail(
        genres = genres,
        id = id,
        original_language = original_language,
        overview = overview,
        poster_path = poster_path,
        production_companies = production_companies,
        production_countries = production_countries,
        release_date = release_date,
        runtime = runtime,
        spoken_languages = spoken_languages,
        title = title,
        vote_average = vote_average,
        vote_count = vote_count
    )
}