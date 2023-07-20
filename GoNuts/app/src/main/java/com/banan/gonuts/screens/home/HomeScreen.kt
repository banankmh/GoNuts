package com.chocolate.dountsapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.banan.gonuts.composables.BottomAppBarRow
import com.banan.gonuts.composables.DonutsCard
import com.banan.gonuts.composables.OffersDountCard
import com.banan.gonuts.composables.WelcomeHeader
import com.banan.gonuts.screens.Screens
import com.banan.gonuts.ui.theme.onPrimary87
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = useDarkIcons)
        onDispose {
            // Restore the default system bars color when the composable is disposed
            systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = useDarkIcons)
        }
    }

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
                OffersDountCard(onClickToDetails = { navController.navigate(Screens.DetailsScreen.route) })
            }
            item {
                DonutsCard()
            }
        }

        BottomAppBarRow(modifier = Modifier.constrainAs(bottomBar) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}