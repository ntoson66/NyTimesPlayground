package com.hdeva.nytimes.repository

import com.hdeva.nytimes.net.api.NyTimesApi
import com.hdeva.nytimes.store.NyTimesStore
import javax.inject.Inject

class NyTimesRepository @Inject constructor(
        private val api: NyTimesApi,
        private val store: NyTimesStore) {
}
