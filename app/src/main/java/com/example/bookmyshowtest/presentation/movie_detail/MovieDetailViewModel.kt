package com.example.bookmyshowtest.presentation.movie_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookmyshowtest.common.Constants
import com.example.bookmyshowtest.common.Response
import com.example.bookmyshowtest.domain.use_case.get_movie_detail.GetMoviesDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMoviesDetailUseCase: GetMoviesDetailUseCase, savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state = _state

    init {
        savedStateHandle.get<String>(Constants.MOVIE_DETAIL_ID)?.let { movieId ->
            getMovieDetail(movieId)
        }
    }

    private fun getMovieDetail(movieId: String) {
        getMoviesDetailUseCase(movieId).onEach { result ->
            when (result) {
                is Response.Success -> {
                    _state.value = MovieDetailState(movie = result.data)
                }
                is Response.Error -> {
                    _state.value = MovieDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Response.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}