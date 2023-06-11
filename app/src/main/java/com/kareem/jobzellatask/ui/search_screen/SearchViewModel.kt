package com.kareem.jobzellatask.ui.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kareem.domain.models.PhotoVM
import com.kareem.domain.result.Resource
import com.kareem.domain.useCases.SearchUseCase
import com.kareem.domain.useCases.UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val searchUseCase: UseCase<SearchUseCase.Params, MutableList<PhotoVM>?>) : ViewModel() {

    private val _images = MutableStateFlow<List<PhotoVM>>(emptyList())
    val images: MutableStateFlow<List<PhotoVM>> = _images

    private val _imagesLoading = MutableStateFlow(true)
    val imagesLoading: MutableStateFlow<Boolean> = _imagesLoading

    fun onSearch(keyword: String) {
        viewModelScope.launch {
            _imagesLoading.value = true
            when (val result = searchUseCase.execute(params = SearchUseCase.Params(keyword))) {
                is Resource.Success -> {
                    _imagesLoading.value = false
                    images.value = result.data ?: emptyList()
                }
                is Resource.Error -> {
                    _imagesLoading.value = false
                    images.value = emptyList()
                }
                else -> {}
            }
        }

    }
}