package com.hdeva.nytimes.ui.home

import android.arch.lifecycle.ViewModel
import com.hdeva.nytimes.model.NyTimesArticles
import com.hdeva.nytimes.repository.NyTimesRepository
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(
        private val repository: NyTimesRepository) : ViewModel() {

    var disposable: Disposable? = null

    init {
        refresh()
    }

    fun refresh() {
        disposable = repository.getDefaultArticles()
                .subscribe({ handleResult(it) }, { (handleError(it)) }, { handleComplete() })
    }

    override fun onCleared() {
        disposable?.dispose()
        disposable = null
    }

    private fun handleResult(result: NyTimesArticles) {

    }

    private fun handleError(throwable: Throwable) {

    }

    private fun handleComplete() {

    }

}
