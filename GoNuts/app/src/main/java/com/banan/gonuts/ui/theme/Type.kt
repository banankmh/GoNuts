package com.banan.gonuts.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.banan.gonuts.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight(600),
        fontSize = 22.sp,
        letterSpacing = 0.5.sp,
        color = onBackground
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight(400),
        fontSize = 12.sp,
        letterSpacing = 0.5.sp,
        color = blackShade
    ),
    bodyMedium= TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight(500),
        fontSize = 18.sp,
        letterSpacing = 0.5.sp,
        color = secondary
    ),
    titleMedium=TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight =  FontWeight(600),
        fontSize = 20.sp,
        letterSpacing = 0.sp,
        color = onBackground
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight =  FontWeight(700),
        fontSize = 54.sp,
        letterSpacing = 0.sp,
        color = primary
    ),
    headlineSmall=TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight(600),
        color = blackShade,
        textDecoration = TextDecoration.LineThrough
    ),
    titleSmall =TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight(600),
        color = primary,
    ),

   labelLarge = TextStyle(
       fontFamily = FontFamily(Font(R.font.inter_regular)),
       fontWeight =  FontWeight(600),
       fontSize =30.sp,
       letterSpacing = 0.sp,
       color = primary
   ),
    labelMedium=TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight =  FontWeight(500),
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        color = onBackground
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight(500),
        fontSize = 14.sp,
        letterSpacing = 0.5.sp,
        color = blackShade
    )

)