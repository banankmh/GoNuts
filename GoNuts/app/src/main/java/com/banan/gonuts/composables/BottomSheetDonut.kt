package com.banan.gonuts.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.gonuts.R
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onBackground
import com.banan.gonuts.ui.theme.onBackground60
import com.banan.gonuts.ui.theme.onBackground80
import com.banan.gonuts.ui.theme.onPrimary

@Composable
fun BottomSheetDonut(modifier:Modifier = Modifier){
    Column(
        modifier = Modifier
            .background(
                color = onPrimary,
                shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)
            )
            .padding(40.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Strawberry Wheel",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = Typography.labelLarge,
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.about_gonut),
            maxLines = 1,
            style = Typography.bodyMedium,
            color= onBackground
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.description),
            style = Typography.labelSmall,
            fontWeight = FontWeight(400),
            color= onBackground60
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Quantity",
            style = Typography.bodyMedium,
            color= onBackground80
        )
        Spacer(modifier = Modifier.height(24.dp))

    }
}

