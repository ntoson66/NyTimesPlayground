package com.hdeva.nytimes.ui.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.hdeva.nytimes.arch.viewmodel.RepositoryLiveData
import com.hdeva.nytimes.extension.connectObservableToLiveData
import com.hdeva.nytimes.model.NyTimesArticles
import com.hdeva.nytimes.repository.NyTimesRepository
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(
        private val repository: NyTimesRepository) : ViewModel() {

    val data: MutableLiveData<RepositoryLiveData<NyTimesArticles>> = MutableLiveData()
    var disposable: Disposable? = null

    init {
        refresh()
    }

    fun refresh() {
        disposable?.dispose()
        disposable = connectObservableToLiveData(repository.getDefaultArticles(), data)
    }

    override fun onCleared() {
        disposable?.dispose()
        disposable = null
    }

}
