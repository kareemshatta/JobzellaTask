package com.kareem.jobzellatask.utils


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kareem.jobzellatask.ui.main_screen.MainScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    navigationActions: AppNavigationActions,
    startDestination: String = AppDestinations.MAIN_SCREEN_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppDestinations.MAIN_SCREEN_ROUTE) {
            MainScreen(navigationActions)
        }
    }
}