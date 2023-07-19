package com.banan.gonuts.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.gonuts.R

@Preview
@Composable
fun FloatingDonut(
    image: Painter = painterResource(id = R.drawable.donut_chocolate_1),
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = stringResource(R.string.floating_dounat),
        modifier = modifier
            .fillMaxWidth()
            .scale(3f)
            .graphicsLayer {
                translationX = 90f
                translationY = 70f
            }
    )
}