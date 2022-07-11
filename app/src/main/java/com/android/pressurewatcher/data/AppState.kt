package com.android.pressurewatcher.data

sealed class AppState{
    data class Success(val data: Any) : AppState()
    data class Error(val error : Throwable) : AppState()
    object Loading: AppState()
}