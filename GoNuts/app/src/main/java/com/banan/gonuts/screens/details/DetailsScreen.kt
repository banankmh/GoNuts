package com.banan.gonuts.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.banan.gonuts.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun DetailsScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = useDarkIcons)
        onDispose {
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = useDarkIcons
            )
        }
    }
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
                    .fillMaxHeight(.88f)
                    .background(color = Color.White)
                    .align(Alignment.BottomCenter)
                    .padding(top = 35.dp, start = 40.dp, end = 40.dp)
            ) {
                TextDetails()
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    ClickAddAndMinus(stringResource(R.string.minus), Black, Color.White, 32)
                    ClickAddAndMinus(stringResource(R.string._1), Black, Color.White, 22)
                    ClickAddAndMinus(stringResource(R.string.plus), Color.White, Color.Black, 32)
                }
                Box(Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = stringResource(R.string._16_),
                            color = Black,
                            fontFamily = FontFamily(Font(R.font.inter_regular)),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        AddToCart()
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


