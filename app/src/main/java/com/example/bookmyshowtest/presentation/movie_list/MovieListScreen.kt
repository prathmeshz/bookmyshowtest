package com.example.bookmyshowtest.presentation.movie_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookmyshowtest.presentation.Screen
import com.example.bookmyshowtest.presentation.movie_list.components.MovieListItem

@Composable
fun MovieListScreen(
    navController: NavController, viewModel: MovieListViewModel = hiltViewModel()
) {
    val moviesState = viewModel.state.value

    Column {
        TopAppBar(
            title = {
                Text(text = "BookMyShow Test", style = MaterialTheme.typography.h2)
            },
            backgroundColor = MaterialTheme.colors.background,
            contentColor = Color.White,
            modifier = Modifier
                .statusBarsPadding()
                .systemBarsPadding()
        )
        SearchView(viewModel.searchQuery, viewModel)
        Box(modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 15.dp, vertical = 15.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(count = moviesState.movies?.size ?: 0) { index ->
                    val movie = moviesState.movies?.get(index);
                    MovieListItem(
                        movie = movie,
                        onItemClick = { navController.navigate(Screen.MovieDetailScreen.route + "/${movie?.id}") }
                    )
                }
            }
            if (moviesState.error.isNotBlank()) {
                Text(
                    text = moviesState.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
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
}


@Composable
fun SearchView(state: MutableState<TextFieldValue>, viewModel: MovieListViewModel) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(onClick = {
                    state.value =
                        TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                }) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = Color(0xFFd3807e),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
    )
}
