package com.kareem.domain.repositories

import com.kareem.domain.models.PhotoVM


interface SearchRepository {
   suspend fun searForKeyword(keyword: String): MutableList<PhotoVM>?
}