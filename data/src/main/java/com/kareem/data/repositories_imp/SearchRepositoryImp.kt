package com.kareem.data.repositories_imp

import com.kareem.data.remote.ApiInterface
import com.kareem.domain.models.PhotoVM
import com.kareem.domain.repositories.SearchRepository

class SearchRepositoryImp(private val service: ApiInterface) : SearchRepository {

    override suspend fun searForKeyword(keyword: String): MutableList<PhotoVM>? =
        service.searchForKeyword(query = keyword).body()?.results
            ?.map { it.map(it) }?.toMutableList()
}