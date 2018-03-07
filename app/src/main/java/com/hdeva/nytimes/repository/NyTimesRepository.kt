package com.hdeva.nytimes.repository

import com.hdeva.nytimes.arch.base.BaseRepository
import com.hdeva.nytimes.model.NyTimesArticles
import com.hdeva.nytimes.net.api.NyTimesApi
import com.hdeva.nytimes.store.NyTimesStore
import io.reactivex.Observable
import javax.inject.Inject

class NyTimesRepository @Inject constructor(
        private val api: NyTimesApi,
        private val store: NyTimesStore) : BaseRepository() {

    companion object {
        private const val DEFAULT_SECTION = "all-sections"
        private const val DEFAULT_PERIOD = "7"
        private const val DEFAULT_OFFSET = 20
    }

    fun getDefaultArticles(): Observable<NyTimesArticles> {
        val remote = queue(api.getNyTimesArticles(DEFAULT_SECTION, DEFAULT_PERIOD, DEFAULT_OFFSET))
                .doOnNext { store.setDefaultArticles(it) }

        return if (store.hasDefaultArticles()) {
            Observable.concat(Observable.fromCallable { store.getDefaultArticles() }, remote)
        } else {
            remote
        }
    }
}
