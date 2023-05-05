package com.example.bookmyshowtest.presentation.movie_list

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookmyshowtest.common.Response
import com.example.bookmyshowtest.domain.use_case.get_movies.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {

    private val _searchQueryState = mutableStateOf(TextFieldValue())
    val searchQuery = _searchQueryState

    private val _originalList = mutableStateOf(MovieListState())

    private val _state = mutableStateOf(MovieListState())
    val state = _state

    init {
        getMovies()
        snapshotFlow { _searchQueryState.value }.onEach { textFieldValue ->
            val pattern = Regex("\\b${textFieldValue.text}[A-Za-z\\d]*")
            val coins = _originalList.value.movies?.filter {
                pattern.containsMatchIn(it.title.lowercase())
            }
            _state.value = MovieListState(
                movies = coins
            )
        }.launchIn(viewModelScope)
    }

    private fun getMovies() {
        getMoviesUseCase().onEach { result ->
            when (result) {
                is Response.Success -> {
                    _state.value = MovieListState(movies = result.data)
                    _originalList.value = MovieListState(movies = result.data)
                }
                is Response.Error -> {
                    _state.value = MovieListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Response.Loading -> {
                    _state.value = MovieListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}