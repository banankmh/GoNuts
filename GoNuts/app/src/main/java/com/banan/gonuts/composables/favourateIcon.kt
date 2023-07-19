package com.banan.gonuts.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.banan.gonuts.R
import com.banan.gonuts.ui.theme.onPrimary
import com.banan.gonuts.ui.theme.primary

@Composable
fun IconFavourite(modifier: Modifier=Modifier){
    Icon(
        painter = painterResource(id = R.drawable.ic_heart),
        contentDescription = stringResource(R.string.favourite_icon),
        modifier = modifier
            .background(color = onPrimary, shape = CircleShape)
            .padding(8.dp)
            .size(35.dp),
        tint = primary
    )
}