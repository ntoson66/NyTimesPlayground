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

    private var disposable: Disposable? = null
    private var nextPageDisposable: Disposable? = null
    private var currentPage = 1

    init {
        refresh()
    }

    fun refresh() {
        disposable?.dispose()
        disposable = connectObservableToLiveData(repository.getDefaultArticles(), data)
    }

    fun getNextPageIfNotLoading() {
        if (nextPageDisposable == null) {
            nextPageDisposable = repository.getArticlesWithOffset(currentPage)
                    .subscribe({ handleNextPage(it) }, { handleNextPageError(it) }, { handleNextPageComplete() })
        }
    }

    override fun onCleared() {
        disposable?.dispose()
        disposable = null

        nextPageDisposable?.dispose()
        nextPageDisposable = null
    }

    private fun handleNextPage(newPage: NyTimesArticles) {
        val newData = RepositoryLiveData.fromLiveData(data)
        newData.result?.articles?.addAll(newPage.articles)
        data.value = newData
        currentPage++
    }

    private fun handleNextPageError(throwable: Throwable) {

    }

    private fun handleNextPageComplete() {
        nextPageDisposable?.dispose()
        nextPageDisposable = null
    }

}
