package com.banan.gonuts.composables

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import com.banan.gonuts.R
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onBackground60


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banan.gonuts.ui.theme.secondary


@Composable
fun WelcomeHeader() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 48.dp, start = 32.dp, end = 32.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = stringResource(R.string.let_s_gonuts),
                style = Typography.titleLarge ,
            )
            Text(
                text = stringResource(R.string.order_your_favourite_donuts_from_here),
              style = Typography.labelSmall
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "icon",
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .clickable { }
                .background(secondary)
                .padding(12.dp)
        )
    }
}