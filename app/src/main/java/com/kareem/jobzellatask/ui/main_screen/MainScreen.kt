package com.kareem.jobzellatask.ui.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.kareem.jobzellatask.R
import com.kareem.jobzellatask.ui.main_screen.components.SearchTextField
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_search_logo_side
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_text_field_radius
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_xlarge
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_xxlarge
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_xxxlarge
import com.kareem.jobzellatask.ui.theme.Gray500
import com.kareem.jobzellatask.ui.theme.Primary
import com.kareem.jobzellatask.ui.theme.White
import com.kareem.jobzellatask.utils.AppNavigationActions
import org.koin.androidx.compose.getViewModel


@Composable
fun MainScreen(navigationActions: AppNavigationActions) {

    val viewModel = getViewModel<SearchViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dim_xxxlarge.dp, start = dim_xxlarge.dp, end = dim_xxlarge.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.search_logo))

        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .size(dim_search_logo_side.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Inside
        )
        Spacer(modifier = Modifier.height(dim_xxxlarge.dp))
        SearchTextField(
            modifier = Modifier,
            viewModel = viewModel
        )
        Spacer(modifier = Modifier.height(dim_xlarge.dp))
        TextButton(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(dim_text_field_radius.dp))
                .background(
                    if (viewModel.searchFieldState.value.isNotEmpty())
                        Primary
                    else
                        Gray500
                ),
            enabled = viewModel.searchFieldState.value.isNotEmpty(),
            interactionSource = MutableInteractionSource(),
            onClick = {
                viewModel.onSearchClicked()
            }) {
            Text(text = LocalContext.current.getString(R.string.search_txt), color = White)
        }
    }
}