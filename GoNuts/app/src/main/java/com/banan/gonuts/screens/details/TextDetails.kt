package com.banan.gonuts.screens.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.banan.gonuts.R
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onBackground
import com.banan.gonuts.ui.theme.onBackground60
import com.banan.gonuts.ui.theme.onBackground80

@Composable
fun TextDetails(){
    Text(
        text = stringResource(id = R.string.strawberry_wheel),
        style = Typography.labelLarge
    )
    Text(
        text = stringResource(R.string.about_gonut),
        style= Typography.bodyMedium,
        color = onBackground,

    )
    Text(
        text = stringResource(R.string.these_soft_cake),
        style= Typography.labelSmall,
        color= onBackground60,
        modifier = Modifier.padding(top = 8.dp)
    )
    Text(
        text = stringResource(R.string.quantity),
        style= Typography.bodyMedium,
        color = onBackground,
        modifier = Modifier.padding(top = 8.dp)
    )
}