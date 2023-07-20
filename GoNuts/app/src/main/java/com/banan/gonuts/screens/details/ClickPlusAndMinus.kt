package com.banan.gonuts.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banan.gonuts.R
import com.banan.gonuts.ui.theme.onBackground

@Composable
fun ClickAddAndMinus(
    text: String,
    textColor: Color = onBackground,
    color: Color,
    textSize: Int
) {
    Surface(
        Modifier.shadow(
            elevation = 4.dp,
            shape = RoundedCornerShape(32),
            spotColor = Color.Black.copy(alpha = .1f)
        )
    ) {
        Box(
            Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(32))
                .clickable {}
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = textColor,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontSize = textSize.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
            )
        }
    }
}