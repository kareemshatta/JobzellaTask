package com.kareem.jobzellatask.ui.search_screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kareem.jobzellatask.ui.shared_components.Header
import com.kareem.jobzellatask.ui.shared_components.ImagesSliderSection
import com.kareem.jobzellatask.ui.theme.Dimen
import com.kareem.jobzellatask.utils.AppNavigationActions
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(navigationActions: AppNavigationActions, keyword: String) {

    val viewModel = getViewModel<SearchViewModel>()

    LaunchedEffect(key1 = true){
        viewModel.onSearch(keyword)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            title = keyword,
            showBack = true,
            onBackClicked = {
                navigationActions.popBackStack()
            }
        )
        Spacer(modifier = Modifier.height(Dimen.dim_xxlarge.dp))
        ImagesSliderSection(viewModel)
    }
}