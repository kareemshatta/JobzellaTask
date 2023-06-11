package com.kareem.data.models

import com.kareem.domain.mapper.Mapper
import com.kareem.domain.models.PhotoVM

data class Photo(
    val id: String?,
    val urls: Map<String, String>?
) : Mapper<Photo, PhotoVM> {

    override fun map(from: Photo): PhotoVM = PhotoVM(
        id = id ?: "",
        url = urls?.get("regular") ?: "",
    )
}