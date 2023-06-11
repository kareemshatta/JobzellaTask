package com.kareem.domain.useCases

import com.kareem.domain.models.PhotoVM
import com.kareem.domain.repositories.SearchRepository
import com.kareem.domain.result.Resource

class SearchUseCase(private val repository: SearchRepository) :
    UseCase<SearchUseCase.Params, MutableList<PhotoVM>?> {
    override suspend fun execute(params: Params): Resource<MutableList<PhotoVM>?> {
        return try {
            val data = repository.searForKeyword(params.keyword)
            if (data == null)
                Resource.Error("empty data")
            else
                Resource.Success(data)
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

    data class Params(
        val keyword: String = ""
    )
}