package com.kareem.jobzellatask.ui.search_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    val searchFieldState = mutableStateOf("")


    fun clearSearchField() {
        searchFieldState.value = ""
    }

    fun onSearch() {
        TODO("Not yet implemented")
    }
}