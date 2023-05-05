package com.example.bookmyshowtest.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bookmyshowtest.R

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.redaction)),
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
    ), h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.redaction)),
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ), subtitle1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ), body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    ), body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,

    )
)
