package com.kareem.domain.useCases

import com.kareem.domain.models.PhotoVM
import com.kareem.domain.repositories.SearchRepository
import com.kareem.domain.result.Resource

class SearchUseCase(private val repository: SearchRepository) {
    suspend operator fun invoke(keyword: String): Resource<MutableList<PhotoVM>?> {
        return try {
            val data = repository.searForKeyword(keyword)
            Resource.Success(data)
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }
}