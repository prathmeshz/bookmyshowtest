package com.example.bookmyshowtest.presentation.movie_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookmyshowtest.presentation.movie_detail.components.MovieDetailItem

@Composable
fun MovieDetailScreen(
    navController: NavController, viewModel: MovieDetailViewModel = hiltViewModel()
) {
    val moviesState = viewModel.state.value

    Box(

    ) {

        if (moviesState.movie != null) {
            MovieDetailItem(
                movie = moviesState.movie,
                onItemClick = { navController.popBackStack() }
            )
        }

        if (moviesState.error.isNotBlank()) {
            Text(
                text = moviesState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (moviesState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}