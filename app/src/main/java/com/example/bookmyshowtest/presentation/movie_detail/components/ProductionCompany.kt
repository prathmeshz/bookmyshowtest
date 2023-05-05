package com.example.bookmyshowtest.presentation.movie_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bookmyshowtest.common.Constants


@Composable
fun ProductionCompany(
    image: String,
    text: String,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(70.dp)
            .width(100.dp)

    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(color = Color.White)
        ) {
            AsyncImage(
                model = "${Constants.BASE_URL_IMAGE}${image}",
                contentDescription = "contentDescription",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
        }
        //        Box(modifier = Modifier.height(10.dp))
        //        Text(
        //            text = text,
        //            style = MaterialTheme.typography.body1,
        //            textAlign = TextAlign.Center,
        //            modifier = Modifier.padding(
        //                vertical = 2.dp, horizontal = 10.dp
        //            )
        //        )
    }

}