package com.banan.gonuts.screens

import com.banan.gonuts.R

sealed class Screens(val route: String,var icon :Int=R.drawable.ic_fav ){
    object OnBoardingScreen: Screens(route = "OnBoardingScreen")
    object HomeScreen: Screens("HomeScreen",icon=R.drawable.ic_home)
    object DetailsScreen: Screens("DetailsScreen")
    object FavouriteScreen : Screens(icon= R.drawable.ic_fav_2, route =  "my_network")
    object NotificationScreen : Screens(icon= R.drawable.ic_notification, route =  "add_post")
    object CartScreen : Screens(icon= R.drawable.ic_buy, route = "notification")
    object ProfileScreen : Screens(icon= R.drawable.ic_profile, route = "jobs")
}
