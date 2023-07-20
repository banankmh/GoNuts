package com.banan.gonuts.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.gonuts.R
import com.banan.gonuts.screens.home.OffersDonutUiState
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.blueSky

@Composable
fun OffersDountCard(
    state: OffersDonutUiState = OffersDonutUiState(),
    backgroundColor: Color = blueSky,
    onClickToDetails: () -> Unit,

) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .height(280.dp)

    ) {
        Column(
            modifier = Modifier
                .width(193.dp)
                .height(320.dp)
                .clickable(onClick = onClickToDetails)
                .background(color = backgroundColor, shape = RoundedCornerShape(20))
                .wrapContentHeight()
                .padding(15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            FloatingDonut(image=state.donatImage)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = state.donatName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = Typography.labelMedium,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = state.donatDescription,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = Typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = "$${state.origin}",
                    style = Typography.headlineSmall,
                    modifier = Modifier.padding(top =8.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "$${state.copun}",
                    style = Typography.bodyLarge,
                )
            }
        }
        IconFavourite(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        )
    }
}
