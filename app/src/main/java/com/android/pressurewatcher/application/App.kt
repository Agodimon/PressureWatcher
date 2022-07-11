package com.android.pressurewatcher.application

import android.app.Application
import com.android.pressurewatcher.di.Di
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    Di.sourceModule(),
                    Di.cloudSourceModule(),
                    Di.repositoryModule(),
                    Di.viewModelsModule()
                )
            )
        }
    }
}