package com.kareem.jobzellatask.di

import com.kareem.jobzellatask.ui.main_screen.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        SearchViewModel()
    }
}