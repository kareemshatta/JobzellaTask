package com.kareem.domain.di

import com.kareem.domain.useCases.SearchUseCase
import org.koin.dsl.module

val domainModule = module {

    single<SearchUseCase> {
        SearchUseCase(get())
    }

}