package com.banan.gonuts.composables


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.banan.gonuts.R
import com.banan.gonuts.ui.theme.onPrimary
import com.banan.gonuts.ui.theme.primary


@Composable
fun BottomAppBarRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = onPrimary)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = modifier.padding(start = 24.dp),
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription ="Home",
            tint = primary
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_fav_2),
            contentDescription ="Fav",
            tint = primary
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_notification),
            contentDescription = "Notififcation",
            tint = primary
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_buy),
            contentDescription = "Cart ",
            tint = primary
        )
        Icon(
            modifier = modifier.padding(end = 24.dp),
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "Profile",
            tint = primary
        )
    }
}