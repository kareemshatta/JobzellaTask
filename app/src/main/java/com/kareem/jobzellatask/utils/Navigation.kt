package com.kareem.jobzellatask.utils

import androidx.navigation.NavHostController

object AppDestinations {
    const val MAIN_SCREEN_ROUTE = "main_screen"
    const val SEARCH_SCREEN_ROUTE = "search_screen"
}

object AppArguments {
    const val SEARCH_KEYWORD = "search_keyword"
}


/**
 * Models the navigation actions in the app.
 */
class AppNavigationActions(private val navController: NavHostController) {
    val popBackStack: () -> Unit = {
        navController.popBackStack()
    }

    val navigateToSearchScreen: (keyword: String) -> Unit = { keyword ->
        navController.navigate(
            "${AppDestinations.SEARCH_SCREEN_ROUTE}/" +
                    "${AppArguments.SEARCH_KEYWORD}=${keyword}"
        )
    }

}

