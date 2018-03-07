package com.hdeva.nytimes.arch.viewmodel

import android.arch.lifecycle.LiveData

class RepositoryLiveData<T> {

    companion object {
        fun <T> fromLiveData(liveData: LiveData<RepositoryLiveData<T>>): RepositoryLiveData<T> {
            val oldData = liveData.value ?: RepositoryLiveData()
            val newData = RepositoryLiveData<T>()
            newData.progress = oldData.progress
            newData.result = oldData.result
            newData.error = oldData.error
            return newData
        }
    }

    var progress: Boolean = true
    var result: T? = null
    var error: Throwable? = null

    val state: State
        get() = when {
            progress && result == null && error == null -> State.PROGRESS
            progress && result != null && error == null -> State.RESULT
            !progress && result != null && error == null -> State.COMPLETE
            !progress && result != null && error != null -> State.OFFLINE
            progress && result == null && error != null -> State.PROGRESS
            !progress && result == null && error != null -> State.ERROR
            else -> State.ERROR
        }

    enum class State {
        PROGRESS, // the live data is starting up
        RESULT, // either local or remote data is available
        OFFLINE, // local data is available, remote data failed for some reason
        COMPLETE, // remote data is available
        ERROR // not even cached data is available
    }
}
