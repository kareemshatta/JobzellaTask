package com.kareem.jobzellatask.di

import com.kareem.domain.useCases.SearchUseCase
import com.kareem.jobzellatask.ui.main_screen.MainScreenViewModel
import com.kareem.jobzellatask.ui.search_screen.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        MainScreenViewModel()
    }

    viewModel {
        SearchViewModel(get() as SearchUseCase)
    }
}