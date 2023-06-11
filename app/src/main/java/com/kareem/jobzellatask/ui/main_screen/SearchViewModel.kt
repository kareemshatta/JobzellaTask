package com.kareem.jobzellatask.ui.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    val searchFieldState = mutableStateOf("")


    fun clearSearchField() {
        searchFieldState.value = ""
    }

    fun onSearchClicked() {
        TODO("Not yet implemented")
    }
}