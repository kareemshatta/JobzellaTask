package com.kareem.jobzellatask.ui.shared_components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.kareem.jobzellatask.R
import com.kareem.jobzellatask.ui.main_screen.MainScreenViewModel
import com.kareem.jobzellatask.ui.theme.Black
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_text_field_height
import com.kareem.jobzellatask.ui.theme.Dimen.Companion.dim_text_field_radius
import com.kareem.jobzellatask.ui.theme.Gray200
import com.kareem.jobzellatask.ui.theme.Gray500


@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchTextField(
    modifier: Modifier,
    viewModel: MainScreenViewModel,
    onSearchClicked: () -> Unit
) {
    val trailingIconView = @Composable {
        Icon(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = "clear icon",
            tint = Black,
            modifier = Modifier
                .clickable {
                    viewModel.clearSearchField()
                }
        )
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(dim_text_field_height.dp)
            .background(
                com.kareem.jobzellatask.ui.theme.White,
                RoundedCornerShape(dim_text_field_radius.dp)
            ),
        value = viewModel.searchFieldState.value,
        onValueChange = {
            viewModel.searchFieldState.value = it
        },
        placeholder = {
            Text(
                text = context.getString(R.string.search_hint),
                style = MaterialTheme.typography.body2,
                modifier = Modifier.fillMaxWidth()
            )
        },
        enabled = true,
        singleLine = true,
        readOnly = false,
        maxLines = 1,
        shape = RoundedCornerShape(dim_text_field_radius.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Gray200,
            unfocusedBorderColor = Gray200,
            placeholderColor = Gray500
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search_icon),
                contentDescription = "search icon",
                tint = Black
            )
        },
        trailingIcon = if (viewModel.searchFieldState.value.isNotEmpty())
            trailingIconView
        else
            null,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                keyboardController?.hide()
                onSearchClicked()
            }
        ),
    )
}
