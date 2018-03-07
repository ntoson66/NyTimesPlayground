package com.hdeva.nytimes.ui.home

import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import com.hdeva.nytimes.R
import com.hdeva.nytimes.ui.adapter.NyTimesArticlesAdapter
import javax.inject.Inject

class HomeActivityPresenter @Inject constructor(
        private val activity: HomeActivity,
        private val adapter: NyTimesArticlesAdapter) {

    fun create() {
        activity.run {
            binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
            viewModel = getViewModel(HomeActivityViewModel::class.java)
        }
        setupViews()
    }

    private fun setupViews() {
        activity.binding.run {
            homeErrorContainer.setOnClickListener { activity.viewModel.refresh() }
            homeRefreshLayout.setOnRefreshListener { activity.viewModel.refresh() }

            homeRecyclerView.layoutManager = LinearLayoutManager(activity)
            homeRecyclerView.adapter = adapter
        }
    }
}
