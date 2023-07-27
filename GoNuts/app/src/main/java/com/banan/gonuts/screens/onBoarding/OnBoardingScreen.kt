package com.banan.gonuts.screens.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.banan.gonuts.R
import com.banan.gonuts.screens.home.navigateToHome
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onPrimary
import com.banan.gonuts.ui.theme.onSecondary


//@Composable
//fun OnBoardingScreen(navController: NavController,){
//    OnBoardingContent(onClickToStart = { navController.navigateToHome() })
//}


@Composable
fun OnBoardingScreen(navController : NavController) {

//    val systemUiController = rememberSystemUiController()
//    val useDarkIcons = !isSystemInDarkTheme()
//    DisposableEffect(systemUiController, useDarkIcons) {
//        systemUiController.setSystemBarsColor(color = onSecondary, darkIcons = useDarkIcons)
//        onDispose {
//            systemUiController.setSystemBarsColor(
//                color = onSecondary,
//                darkIcons = useDarkIcons
//            )
//        }
//    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = onSecondary)
    ) {
        val (
            boxDonuts,
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
                        .offset(y = 30.dp, x = 17.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.donut_eaten),
                    contentDescription = stringResource(R.string.let_s_gonuts),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .scale(.9f)
                        .offset(x = 90.dp, y = 200.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.donut_strawberry_3),
                    contentDescription = stringResource(R.string.let_s_gonuts),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = (-35).dp, y = (15).dp)
                        .scale(.85f)
                )

                Image(
                    painter = painterResource(id = R.drawable.donut_strawberry_3),
                    contentDescription = stringResource(R.string.let_s_gonuts),
                    modifier = Modifier
                        .scale(.4f)
                        .rotate(65f)
                        .align(Alignment.BottomStart)
                        .offset(y = 100.dp, x = 80.dp)
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

        Column(modifier = Modifier.padding(24.dp).constrainAs(getStartedButton){
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
        }
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Text("Gonuts\n" + "with\n" + "Donuts",
                style = Typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text="Gonuts with Donuts" +
                        " is a Sri Lanka" +
                        " dedicated food outlets " +
                        "for specialize manufacturing of Donuts in Colombo, Sri Lanka.",
                style= Typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigateToHome() }, modifier = Modifier
                    .height(54.dp)
                    .fillMaxWidth(),
                colors=ButtonDefaults.buttonColors(containerColor = onPrimary)
            ) {
                Text(text = stringResource(R.string.getstarted), style = Typography.titleMedium)
            }
        }
    }

}



