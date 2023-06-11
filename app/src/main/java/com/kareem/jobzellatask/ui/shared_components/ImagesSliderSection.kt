@file:OptIn(ExperimentalFoundationApi::class)

package com.kareem.jobzellatask.ui.shared_components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kareem.jobzellatask.R
import com.kareem.jobzellatask.ui.search_screen.SearchViewModel
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_large
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_small
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_xlarge
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.home_slider_content_padding
import com.kareem.jobzellatask.ui.theme.Gray200
import com.kareem.jobzellatask.ui.theme.ShimmerBg
import com.kareem.jobzellatask.utils.shimmer
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ImagesSliderSection(
    viewModel: SearchViewModel
) {
    if (viewModel.imagesLoading.collectAsState().value)
        ImagesSliderSectionShimmer()
    else
        ImagesSlider(viewModel.images)
}

@Composable
fun ImagesSlider(
    images: MutableStateFlow<List<String>>,
) {
    val imageList = images.collectAsState().value
    val pagerState = rememberPagerState(initialPage = 1)

    HorizontalPager(
        state = pagerState,
        pageCount = imageList.size,
        contentPadding = PaddingValues(
            horizontal = home_slider_content_padding.dp,
            vertical = 1.dp
        ),
        pageSpacing = dim_small.dp,
        modifier = Modifier
            .padding(top = dim_small.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(6.dp))
    ) { page ->
        Card {
            AsyncImage(
                model = imageList[page],
                placeholder = painterResource(id = R.drawable.ic_image_placholder),
                error = painterResource(R.drawable.ic_image_placholder),
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(2.5f)
                    .clip(RoundedCornerShape(6.dp)),
                contentDescription = "images slider",
                filterQuality = FilterQuality.High,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
fun ImagesSliderSectionShimmer() {
    Row {
        Spacer(modifier = Modifier.width(dim_xlarge.dp))
        ImagesSliderShimmerItem()
        Spacer(modifier = Modifier.width(dim_large.dp))
        ImagesSliderShimmerItem()
    }
}

@Composable
fun ImagesSliderShimmerItem() {
    Row(modifier = Modifier.shimmer(800, 120)) {
        Spacer(
            modifier = Modifier
                .width(280.dp)
                .height(130.dp)
                .border(
                    width = 1.dp,
                    color = Gray200,
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(8.dp))
                .background(ShimmerBg)
                .shimmer(800, 60),
        )
    }
}