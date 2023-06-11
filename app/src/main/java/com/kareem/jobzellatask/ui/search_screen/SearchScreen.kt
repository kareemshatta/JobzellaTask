package com.kareem.jobzellatask.ui.search_screen


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_xxlarge
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_xxxlarge
import com.kareem.jobzellatask.utils.AppNavigationActions
import org.koin.androidx.compose.getViewModel


@Composable
fun SearchScreen(navigationActions: AppNavigationActions) {

    val viewModel = getViewModel<SearchViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dim_xxxlarge.dp, start = dim_xxlarge.dp, end = dim_xxlarge.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }
}