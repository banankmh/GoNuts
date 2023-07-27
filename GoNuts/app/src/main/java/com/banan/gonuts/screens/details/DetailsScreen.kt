package com.banan.gonuts.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.banan.gonuts.R
import com.banan.gonuts.composables.ButtonItem
import com.banan.gonuts.composables.CounterDesign
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onPrimary
import com.banan.gonuts.ui.theme.primary

@Composable
fun DetailsScreen(navController: NavController,viewModel: DetailsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

//    val systemUiController = rememberSystemUiController()
//    val useDarkIcons = !isSystemInDarkTheme()
//    DisposableEffect(systemUiController, useDarkIcons) {
//        systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = useDarkIcons)
//        onDispose {
//            systemUiController.setSystemBarsColor(
//                color = Color.Transparent,
//                darkIcons = useDarkIcons
//            )
//        }
//    }


    Box(modifier = Modifier.fillMaxSize()) {
        HeaderDetails()
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(.60f)
                .align(Alignment.BottomCenter)
        ) {
            Column(
                Modifier
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = White)
                    .align(Alignment.BottomCenter)
                    .padding(top = 48.dp, start = 40.dp, end = 40.dp)
            ) {
                TextDetails()
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    CounterDesign(
                        onClickPlus = viewModel::increaseQuantity,
                        onClickMinus =  viewModel::decreaseQuantity,
                        quantity = if (state.quantity > 16) 0 else state.quantity
                    )

                }
                Box() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "£${state.origin}",
                            style = Typography.titleMedium,
                        )

//                        AddToCart()

                        ButtonItem(
                            text = stringResource(R.string.add_to_cart),
                            onClick = {},
                            backgroundColor = primary,
                            textColor = onPrimary,
                            modifier = Modifier.padding(8.dp)
                        )

                    }
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 32.dp, top = 36.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(32),
                        spotColor = Color.Black.copy(alpha = .1f)
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_fav),
                    contentDescription = stringResource(R.string.add_to_favourite_icon),
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(White)
                        .padding(8.dp)
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = stringResource(R.string.back_icon),
            modifier = Modifier
                .clickable { navController.popBackStack() }
                .align(Alignment.TopStart)
                .padding(35.dp)
        )
    }
}


