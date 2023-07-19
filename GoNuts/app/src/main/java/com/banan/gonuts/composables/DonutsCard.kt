package com.banan.gonuts.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.gonuts.R
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onBackground60
import com.banan.gonuts.ui.theme.onPrimary
import com.banan.gonuts.ui.theme.onSecondary

@Composable
fun DonutsCard(
    name: String,
    price: Int,
    image: Painter
){
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .width(138.dp)

    ) {
        Column(
            Modifier
                .width(138.dp)
                .height(158.dp)
                .padding(top = 32.dp)
                .background(
                    color = onPrimary,shape = RoundedCornerShape(
                        topStart = 20.dp, topEnd = 20.dp, bottomEnd = 10.dp, bottomStart = 10.dp
                    )
                )
            ,

            Arrangement.Bottom

        ){
            Text(
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = Typography.labelSmall,
                color= onBackground60,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 10.dp)
            )
            Text(
                text = "$$price",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = Typography.titleSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                  .padding(bottom=20.dp)
            )
        }
        Image(
            painter = image,
            contentDescription = stringResource(R.string.floating_dounat),
            modifier = Modifier
                .scale(.9f).width(120.dp)
                .graphicsLayer {
                    translationX = 30f
                    translationY =-70f
                }
        )
    }

}

@Preview (showSystemUi = true)
@Composable
fun DonutsPreview(){
    DonutsCard("Chocolate Cherry",16, painterResource(id = R.drawable.donut_strawberry_1))
}
