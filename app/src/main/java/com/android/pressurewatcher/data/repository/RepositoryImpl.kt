package com.android.pressurewatcher.data.repository

import com.android.pressurewatcher.data.models.Health
import com.android.pressurewatcher.data.datasource.DataSource

import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val cloudSource: DataSource
) : Repository {
    override fun getData(): Flow<List<Health>> = cloudSource.getData()

    override suspend fun setData(health: Health) = cloudSource.setData(health)
}