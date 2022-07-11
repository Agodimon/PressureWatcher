package com.android.pressurewatcher.data.repository

import com.android.pressurewatcher.data.models.Health

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getData() : Flow<List<Health>>
    suspend fun setData(health: Health)
}