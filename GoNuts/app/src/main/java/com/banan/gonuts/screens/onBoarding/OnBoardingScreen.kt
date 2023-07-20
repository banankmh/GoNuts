package com.banan.gonuts.screens.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.banan.gonuts.R
import com.banan.gonuts.screens.home.navigateToHome
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onPrimary
import com.banan.gonuts.ui.theme.onSecondary


@Composable
fun OnBoardingScreen(navController: NavController,){
    OnBoardingContent(onClickToStart = { navController.navigateToHome() })
}

@Composable
fun OnBoardingContent(onClickToStart: () -> Unit){
    Box( modifier = Modifier
        .fillMaxSize()
        .background(color = onSecondary)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.donut_group),
                contentDescription = " Group of Dounts",
                modifier = Modifier
                    .matchParentSize()
                    .rotate(25f)
                    .scale(1.7f, 1.7f)
                    .offset(y = 70.dp, x = 17.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.donut_eaten),
                contentDescription = "Strawabry topic",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .scale(.9f)
                    .offset(x = 96.dp, y = 232.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.donut_strawberry_3),
                contentDescription = "Strawabry topic",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = (-35).dp, y = (25).dp)
                    .scale(.85f)
            )
            Image(
                painter = painterResource(id = R.drawable.donut_strawberry_3),
                contentDescription = "Strawabry topic",
                modifier = Modifier
                    .scale(.4f)
                    .rotate(65f)
                    .align(Alignment.BottomStart)
                    .offset(y = 120.dp, x = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.donut_move),
                contentDescription ="Strawabry topic",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .scale(.9f)
                    .offset(x = (-30).dp, y = (-42).dp)
            )
        }

        Column(modifier = Modifier.padding(40.dp)
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
                onClick = { onClickToStart() }, modifier = Modifier
                    .height(54.dp)
                    .fillMaxWidth(),
                colors=ButtonDefaults.buttonColors(containerColor = onPrimary)
            ) {
                Text(text = stringResource(R.string.getstarted), style = Typography.titleMedium)
            }
        }
    }

}

@Preview
@Composable
fun OnBoardingPreview(){
    OnBoardingContent({})
}