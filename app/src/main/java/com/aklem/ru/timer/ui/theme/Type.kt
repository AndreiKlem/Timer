package com.aklem.ru.timer.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aklem.ru.timer.R

val MontserratRegular = FontFamily(
    Font(R.font.montserrat_regular)
)

val MontserratAlternatives = FontFamily(
    Font(R.font.montserrat_alternatives_medium)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = MontserratRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 72.sp,
        color = Color.White
    ),
    h2 = TextStyle(
        fontFamily = MontserratRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 72.sp,
        color = Color.Black
    ),
    h5 = TextStyle(
        fontFamily = MontserratAlternatives,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)