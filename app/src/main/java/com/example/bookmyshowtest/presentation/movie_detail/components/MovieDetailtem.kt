package com.example.bookmyshowtest.presentation.movie_detail.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bookmyshowtest.common.Constants
import com.example.bookmyshowtest.domain.model.Movie
import com.example.bookmyshowtest.domain.model.MovieDetail


@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterialApi::class)
@Composable
fun MovieDetailItem(
    movie: MovieDetail?, onItemClick: () -> Unit
) {

    val companiesScrollState = rememberScrollState()
    val langScrollState = rememberScrollState()

    Box {
        Box {

            AsyncImage(
                model = "${Constants.BASE_URL_IMAGE}${movie?.poster_path}",
                contentDescription = "contentDescription",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0xBE000000),
                                Color(0xCC000000),
                                Color(0xE6000000)
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
            IconButton(onClick = onItemClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(weight = 1f)
            )
            Text(
                movie?.title.orEmpty(),
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            FlowRow (

                    ){
                Text(
                    "Releasing On ${movie?.release_date}, ",
                    style = MaterialTheme.typography.subtitle1
                )
                movie?.spoken_languages?.forEach { language ->
                    Text(
                        "${language.name},",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                }
            }
            Text(
                "Genres",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(vertical = 15.dp)
            )

            FlowRow(
                modifier = Modifier,
            ) {
                movie?.genres?.forEach { it ->
                    TextChip(it.name)
                }
            }
            Text(
                "About The Movie",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(vertical = 15.dp)
            )
            Text(
                "${movie?.overview}", style = MaterialTheme.typography.subtitle1
            )
            Text(
                "Production Companies",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(vertical = 15.dp)
            )

            Row(
                modifier = Modifier.horizontalScroll(companiesScrollState)
            ) {
                movie?.production_companies?.forEach { company ->
                    ProductionCompany(
                        text = company.name.orEmpty(), image = company.logo_path.orEmpty()
                    )
                }
            }

        }

    }
}

