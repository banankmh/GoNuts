package com.banan.gonuts.composables


import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.banan.gonuts.ui.theme.onBackground80


@Composable
fun ButtonIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    painter: Painter,
    iconTint: Color = onBackground80,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = iconTint
        )
    }
}
