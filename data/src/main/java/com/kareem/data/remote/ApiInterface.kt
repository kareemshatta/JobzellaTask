package com.kareem.data.remote

import com.kareem.data.models.SearchResponse
import com.kareem.data.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("/search/photos")
    suspend fun searchForKeyword(
        @Query("query")
        query: String,
        @Query("orientation")
        orientation: String = "landscape",
        @Query("page")
        pageNumber: Int = 1,
        @Query("client_id")
        client_id: String = Constants.ACCESS_KEY
    ): Response<SearchResponse>
}