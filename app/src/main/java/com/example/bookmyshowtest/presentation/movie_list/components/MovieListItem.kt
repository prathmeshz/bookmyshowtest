package com.example.bookmyshowtest.presentation.movie_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bookmyshowtest.common.Constants
import com.example.bookmyshowtest.domain.model.Movie


@Composable
fun MovieListItem(
    movie: Movie?, onItemClick: (Movie?) -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(280.dp)
        .clickable { onItemClick(movie) }
        .padding(top = 20.dp)
        .clip(shape = RoundedCornerShape(15.dp))
        .shadow(
            elevation = 50.dp,
            shape = RoundedCornerShape(10.dp),
            spotColor = Color.Red,
        )) {
        Box {
            AsyncImage(
                model = "${Constants.BASE_URL_IMAGE}${movie?.poster_path}",
                contentDescription = "Translated description of what the image contains",
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color(0x64000000), Color(0xB4000000), Color.Black
                            )
                        )
                    )
                    .fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(weight = 1f)
            )
            Text(
                movie?.title.orEmpty(),
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                movie?.release_date.orEmpty(), style = MaterialTheme.typography.subtitle1
            )
        }
    }
}
