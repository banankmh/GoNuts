package com.banan.gonuts.screens

sealed class Screens(val route: String){
    object OnBoardingScreen: Screens("OnBoardingScreen")
    object HomeScreen: Screens("HomeScreen")
    object DetailsScreen: Screens("DetailsScreen")
}
