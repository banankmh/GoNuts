package com.banan.gonuts.screens.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.banan.gonuts.R
import com.banan.gonuts.screens.Screens
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onSecondary
import com.banan.gonuts.ui.theme.primary
import com.google.accompanist.systemuicontroller.rememberSystemUiController


//@Composable
//fun OnBoardingScreen(navController: NavController,){
//    OnBoardingContent(onClickToStart = { navController.navigateToHome() })
//}

@Composable
fun OnBoardingScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(color = onSecondary, darkIcons = useDarkIcons)
        onDispose {
            systemUiController.setSystemBarsColor(
                color = onSecondary,
                darkIcons = useDarkIcons
            )
        }
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = onSecondary)
    ) {
        val (boxDonuts,
            textTitle,
            textDescription,
            getStartedButton
        ) = createRefs()
        Box(
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(boxDonuts) {}
        ) {
            Box(
                Modifier
                    .fillMaxHeight(.43f)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.donut_group),
                    contentDescription = stringResource(R.string.group_of_dounts),
                    modifier = Modifier
                        .matchParentSize()
                        .rotate(20f)
                        .scale(1.7f, 1.7f)
                        .offset(y = 40.dp, x = 17.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.donut_eaten),
                    contentDescription = stringResource(R.string.let_s_gonuts),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .scale(.9f)
                        .offset(x = 90.dp, y = 232.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.donut_strawberry_3),
                    contentDescription = stringResource(R.string.let_s_gonuts),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = (-35).dp, y = (25).dp)
                        .scale(.85f)
                )

                Image(
                    painter = painterResource(id = R.drawable.donut_strawberry_3),
                    contentDescription = stringResource(R.string.let_s_gonuts),
                    modifier = Modifier
                        .scale(.4f)
                        .rotate(65f)
                        .align(Alignment.BottomStart)
                        .offset(y = 120.dp, x = 80.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.donut_move),
                    contentDescription = stringResource(R.string.let_s_gonuts),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .scale(.9f)
                        .offset(x = (-30).dp, y = (-42).dp)
                )
            }
        }

        Text(
            modifier = Modifier.constrainAs(textTitle) {
                top.linkTo(boxDonuts.bottom, margin = 56.dp)
                start.linkTo(parent.start, margin = 32.dp)
            },
            text = "Let’s \n Gonuts!",
            style = Typography.titleLarge,

            )
        Text(
            modifier = Modifier.constrainAs(textDescription) {
                top.linkTo(textTitle.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 32.dp)
            },
            text = stringResource(R.string.description),
            style = Typography.bodyMedium,
        )
        Button(
            modifier = Modifier
                .constrainAs(getStartedButton) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                }, onClick = { navController.navigate(Screens.HomeScreen.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
            )
        ) {
            Text(
                text = stringResource(R.string.getstarted),
                style = Typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 88.dp)
            )
        }
    }
}

