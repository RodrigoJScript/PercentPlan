package com.rodrigojscript.percentplan

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigojscript.percentplan.ui.screens.Main
import com.rodrigojscript.percentplan.ui.theme.SplashScreen
import com.rodrigojscript.percentplan.viewmodel.PercentPlanViewModel

sealed class NavGraph(val route: String) {
    object SplashScreen : NavGraph("splash_screen")
    object Main : NavGraph("main_screen")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavGraph.SplashScreen.route) {
        composable(NavGraph.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(NavGraph.Main.route) {
            Main(viewModel = PercentPlanViewModel())
        }
    }
}