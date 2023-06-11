package com.kareem.jobzellatask.utils


import android.view.Window
import android.view.WindowManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kareem.jobzellatask.ui.main_screen.MainScreen
import com.kareem.jobzellatask.ui.search_screen.SearchScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    navigationActions: AppNavigationActions,
    window: Window,
    startDestination: String = AppDestinations.MAIN_SCREEN_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppDestinations.MAIN_SCREEN_ROUTE) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
            MainScreen(navigationActions)
        }
        composable(
            "${AppDestinations.SEARCH_SCREEN_ROUTE}/" +
                    "${AppArguments.SEARCH_KEYWORD}={${AppArguments.SEARCH_KEYWORD}}",
            arguments = listOf(
                navArgument(AppArguments.SEARCH_KEYWORD) {
                    type = NavType.StringType
                },
            )
        ) {
            val keyword = it.arguments?.getString(AppArguments.SEARCH_KEYWORD) ?: ""
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
            SearchScreen(navigationActions, keyword)
        }
    }
}
