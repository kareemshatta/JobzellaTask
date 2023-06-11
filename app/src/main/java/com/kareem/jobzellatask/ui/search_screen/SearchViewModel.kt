package com.kareem.jobzellatask.ui.search_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SearchViewModel : ViewModel() {

    private val _images = MutableStateFlow<List<String>>(emptyList())
    val images: MutableStateFlow<List<String>> = _images

    private val _imagesLoading = MutableStateFlow(true)
    val imagesLoading: MutableStateFlow<Boolean> = _imagesLoading

    fun onSearch(keyword: String) {
//        TODO("Not yet implemented")
    }
}