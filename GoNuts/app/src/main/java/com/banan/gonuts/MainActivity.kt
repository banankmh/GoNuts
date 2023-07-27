package com.banan.gonuts

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.banan.gonuts.ui.theme.GoNutsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("SuspiciousIndentation", "UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoNutsTheme {
//                val systemUiController = rememberSystemUiController()
//                systemUiController.isStatusBarVisible = false
//                val navController = rememberNavController()
//                Scaffold(bottomBar = {
//                    val currentRoute = navController.currentBackStackEntry?.destination?.route
//                    if (currentRoute != Screens.OnBoardingScreen.route) {
//                        BottomNavigationBar(navController = navController)
//                    }
//                }
//                ) {
//                    GoNutsNavGraph()
//                }
                GoNutsNavGraph()

            }
        }
        }
    }