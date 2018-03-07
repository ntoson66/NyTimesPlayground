package com.hdeva.nytimes.ui.home

import android.arch.lifecycle.ViewModel
import com.hdeva.nytimes.repository.NyTimesRepository
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(
        private val repository: NyTimesRepository) : ViewModel() {
}
