package com.davidchura.proyectoloki.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.davidchura.proyectoloki.R

val Urbanist = FontFamily(
    Font(R.font.urbanist_regular, FontWeight.Normal),
    Font(R.font.urbanist_bold, FontWeight.Bold),
    Font(R.font.urbanist_black, FontWeight.Black),
    Font(R.font.urbanist_extralight, FontWeight.ExtraLight)
)

val AppTypography = Typography(
    displayLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Black
    ),

    headlineLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Bold
    ),

    headlineMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Bold
    ),

    titleLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Bold
    ),

    titleMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Bold
    ),

    bodyLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Normal
    ),

    bodyMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Normal
    ),

    labelLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Bold
    )
)