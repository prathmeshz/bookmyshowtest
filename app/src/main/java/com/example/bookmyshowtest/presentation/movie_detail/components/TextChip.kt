package com.example.bookmyshowtest.presentation.movie_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextChip(
    text: String,
) {
    Row {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    vertical = 4.dp,
                )
                .background(
                    color = Color(0xFF774754),
                    shape = MaterialTheme.shapes.medium
                )
                .clip(shape = MaterialTheme.shapes.medium)
                .padding(4.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(
                        vertical = 2.dp,
                        horizontal = 10.dp
                    )
            )
        }
        Box(modifier = Modifier.width(10.dp))
    }
}