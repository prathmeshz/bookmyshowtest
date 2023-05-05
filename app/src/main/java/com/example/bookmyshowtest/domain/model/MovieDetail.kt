package com.example.bookmyshowtest.domain.model

import com.example.bookmyshowtest.data.remote.dto.movie_detail.Genre
import com.example.bookmyshowtest.data.remote.dto.movie_detail.ProductionCompany
import com.example.bookmyshowtest.data.remote.dto.movie_detail.ProductionCountry
import com.example.bookmyshowtest.data.remote.dto.movie_detail.SpokenLanguage

data class MovieDetail(
    val genres: List<Genre>,
    val id: Int,
    val original_language: String,
    val overview: String,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)