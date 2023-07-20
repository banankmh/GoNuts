package com.banan.gonuts.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.banan.gonuts.R
import com.banan.gonuts.composables.BottomSheetDonut
import com.banan.gonuts.composables.ButtonIcon
import com.banan.gonuts.composables.ButtonItem
import com.banan.gonuts.composables.CounterDesign
import com.banan.gonuts.composables.customShadow
import com.banan.gonuts.screens.home.OffersDonutUiState
import com.banan.gonuts.screens.onBoarding.navigateToOnBoarding
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onPrimary
import com.banan.gonuts.ui.theme.onSecondary
import com.banan.gonuts.ui.theme.primary

@Composable
fun DetailsScreen(
    navController:NavController,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    DetailsContent(
        state = state,
        onClickBack = navController::popBackStack,
        increaseQuantity = viewModel::increaseQuantity,
        decreaseQuantity = viewModel::decreaseQuantity,
        onClickFavorite = navController::navigateToOnBoarding,
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsContent(
    state: OffersDonutUiState,
    onClickBack: () -> Unit,
    increaseQuantity: () -> Unit,
    decreaseQuantity: () -> Unit,
    onClickFavorite: () -> Unit,
) {
    Scaffold(content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = onSecondary)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .height(340.dp)
                    .fillMaxWidth()
            ) {

                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.donut_strawberry_4),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                ButtonIcon(
                    modifier = Modifier.align(Alignment.TopStart),
                    onClick = onClickBack,
                    iconTint =primary,
                    painter = painterResource(id = R.drawable.ic_arrow_back)
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .zIndex(6f)
                    .offset(x = (-50).dp, y = (-80).dp)
            )
            {
                ButtonIcon(
                    modifier = Modifier
                        .size(45.dp)
                        .customShadow(shape = RoundedCornerShape(15.dp))
                        .background(shape = RoundedCornerShape(15.dp), color = onPrimary)
                        .clip(RoundedCornerShape(15.dp)),
                    onClick = onClickFavorite,
                    iconTint = primary,
                    painter = painterResource(id = R.drawable.ic_fav)
                )
            }

            BottomSheetDonut(modifier = Modifier.align(Alignment.BottomCenter))

            Row(modifier = Modifier.fillMaxWidth()) {
                CounterDesign(onClickMinus = {})
                Spacer(modifier = Modifier.width(16.dp))
                CounterDesign(quantity = 1)
                Spacer(modifier = Modifier.width(16.dp))
                CounterDesign(onClickPlus = {})
            }

                CounterDesign(
                    onClickPlus = increaseQuantity,
                    onClickMinus = decreaseQuantity,
                    quantity = if (state.quantity > 16) 0 else state.quantity
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "£${state.origin}",
                        style = Typography.titleMedium,
                    )
                    ButtonItem(
                        text = stringResource(R.string.add_to_cart),
                        onClick = {},
                        backgroundColor = primary,
                        textColor = onPrimary,
                        modifier = Modifier.width(200.dp)
                    )

                }
            }
        })
    }

