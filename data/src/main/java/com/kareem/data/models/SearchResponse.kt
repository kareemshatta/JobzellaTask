package com.kareem.data.models

data class SearchResponse(
    val results: List<Photo>,
    val total: Int,
    val total_pages: Int
)