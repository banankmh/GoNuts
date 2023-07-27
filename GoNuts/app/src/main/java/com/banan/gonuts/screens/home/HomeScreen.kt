package com.chocolate.dountsapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.banan.gonuts.composables.BottomAppBarRow
import com.banan.gonuts.composables.DonutsCard
import com.banan.gonuts.composables.OffersDountCard
import com.banan.gonuts.composables.WelcomeHeader
import com.banan.gonuts.screens.details.navigateToDetails
import com.banan.gonuts.screens.home.Donuts
import com.banan.gonuts.screens.home.DonutsOffers
import com.banan.gonuts.screens.home.HomeViewModel
import com.banan.gonuts.ui.theme.onPrimary87
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel(),) {
    val state by viewModel.state.collectAsState()
//    val systemUiController = rememberSystemUiController()
//    val useDarkIcons = !isSystemInDarkTheme()
//    DisposableEffect(systemUiController, useDarkIcons) {
//        systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = useDarkIcons)
//        onDispose {
//            systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = useDarkIcons)
//        }
//    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (columnScreen, bottomBar) = createRefs()
        LazyColumn(
            Modifier
                .background(color = onPrimary87)
                .fillMaxSize()
                .constrainAs(columnScreen) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            item {
                WelcomeHeader()
            }
            item{
                DonutsOffers(onClick = {navController.navigateToDetails()}, offers =state.offersDonut)
            }
            item {
                Donuts(donuts =state.donuts)
            }
        }

        BottomAppBarRow(modifier = Modifier.constrainAs(bottomBar) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}