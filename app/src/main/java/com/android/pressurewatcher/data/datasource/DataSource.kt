package com.android.pressurewatcher.data.datasource

import com.android.pressurewatcher.data.models.Health

import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getData(): Flow<List<Health>>
    suspend fun setData(health: Health)
}