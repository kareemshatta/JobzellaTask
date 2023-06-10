package com.kareem.jobzellatask.utils

import android.app.Application
import com.kareem.data.di.dataModule
import com.kareem.domain.di.domainModule
import com.kareem.jobzellatask.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(dataModule, domainModule, appModule))
        }

    }
}