package com.banan.gonuts.composables

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.banan.gonuts.ui.theme.onBackground30

@Stable
fun Modifier.customShadow(shape: Shape) = then(
    this.shadow(
        elevation = 10.dp,
        shape = shape,
        ambientColor = onBackground30,
        spotColor = onBackground30
    )
)