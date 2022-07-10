package com.android.pressurewatcher.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.pressurewatcher.data.AppState
import com.android.pressurewatcher.data.models.Health
import com.android.pressurewatcher.data.repository.Repository
import kotlinx.coroutines.*

class MainViewModel(
    private val repository: Repository
) : ViewModel() {
    private val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }
    )
    private val liveData = MutableLiveData<AppState>()

    fun getLiveData(): LiveData<AppState> = liveData
    fun getData() {
        viewModelCoroutineScope.launch {
            repository.getData().collect { healthList ->
                liveData.postValue(healthList.let { healthList -> AppState.Success(healthList) })
            }
        }
    }

    fun saveData(health: Health) {
        viewModelCoroutineScope.launch {
            repository.setData(health)
            getData()
        }
    }

    private fun handleError(throwable: Throwable) {
        liveData.postValue(AppState.Error(throwable))
    }

    override fun onCleared() {
        viewModelCoroutineScope.cancel()
        super.onCleared()
    }
}