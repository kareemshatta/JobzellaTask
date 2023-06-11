package com.kareem.jobzellatask.ui.shared_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kareem.jobzellatask.R
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_top_bar_height
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_xlarge
import com.kareem.jobzellatask.ui.theme.Gray800
import com.kareem.jobzellatask.ui.theme.White

@Composable
fun Header(
    title: String,
    modifier: Modifier = Modifier,
    showBack: Boolean = false,
    onBackClicked: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(dim_top_bar_height.dp)
            .background(color = White)
    ) {
        if (showBack)
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_left_black),
                contentDescription = "back btn",
                modifier = Modifier
                    .padding(dim_xlarge.dp)
                    .clickable {
                        onBackClicked()
                    }
                    .align(Alignment.CenterStart)
            )

        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            color = Gray800,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}