package com.banan.gonuts.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.banan.gonuts.R
import com.banan.gonuts.composables.OffersDountCard
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.blueSky
import com.banan.gonuts.ui.theme.onSecondary


@Composable
fun DonutsOffers(
    offers: List<OffersDonutUiState>,
    onClick: () -> Unit = {}
) {
    Text(
    text = stringResource(R.string.today_offers),
    style = Typography.titleMedium,
    modifier = Modifier
        .fillMaxWidth()
        .padding(top = 25.dp)
        .padding(horizontal = 16.dp)
)
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(items = offers) { position, items ->
            val backgroundColor = if (position % 2 == 0) blueSky  else onSecondary
            OffersDountCard(state =  items,backgroundColor, onClickToDetails = onClick)
        }
    }
}