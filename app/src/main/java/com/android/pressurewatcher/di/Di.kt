package com.android.pressurewatcher.di

import com.android.pressurewatcher.ui.main.MainFragment
import com.android.pressurewatcher.ui.main.MainViewModel
import com.google.firebase.database.FirebaseDatabase
import com.android.pressurewatcher.data.datasource.DataSource
import com.android.pressurewatcher.data.repository.Repository
import com.android.pressurewatcher.data.repository.RepositoryImpl
import com.android.pressurewatcher.data.datasource.DataSourceImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Di {
    fun sourceModule() = module {
        single {
            FirebaseDatabase.getInstance()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun cloudSourceModule() = module {
        single<DataSource> {
            DataSourceImpl(get())
        }
    }

    fun repositoryModule() = module {
        single<Repository> {
            RepositoryImpl(get())
        }
    }

    fun viewModelsModule() = module {
        scope<MainFragment> {
            viewModel { MainViewModel(get()) }
        }
    }
}