package com.hdeva.nytimes.extension

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.hdeva.nytimes.arch.viewmodel.RepositoryLiveData
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

@Suppress("unused")
fun <T> ViewModel.connectObservableToLiveData(observable: Observable<T>, liveData: MutableLiveData<RepositoryLiveData<T>>): Disposable {
    liveData.value = RepositoryLiveData()
    return observable.subscribe({
        val data = RepositoryLiveData.fromLiveData(liveData)
        data.result = it
        data.error = null
        liveData.value = data
    }, {
        val data = RepositoryLiveData.fromLiveData(liveData)
        data.progress = false
        data.error = it
        liveData.value = data
    }, {
        val data = RepositoryLiveData.fromLiveData(liveData)
        data.progress = false
        liveData.value = data
    })
}
