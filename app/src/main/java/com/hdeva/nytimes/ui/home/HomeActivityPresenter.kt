package com.hdeva.nytimes.ui.home

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import com.hdeva.nytimes.R
import com.hdeva.nytimes.arch.viewmodel.RepositoryLiveData
import com.hdeva.nytimes.extension.invisible
import com.hdeva.nytimes.extension.visible
import com.hdeva.nytimes.model.NyTimesArticles
import com.hdeva.nytimes.ui.adapter.NyTimesArticlesAdapter
import javax.inject.Inject

class HomeActivityPresenter @Inject constructor(
        private val activity: HomeActivity,
        private val adapter: NyTimesArticlesAdapter) {

    fun create() {
        with(activity) {
            binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
            viewModel = getViewModel(HomeActivityViewModel::class.java)
        }
        setupViews()
        observe()
    }

    private fun setupViews() {
        with(activity.binding) {
            homeErrorContainer.setOnClickListener { activity.viewModel.refresh() }
            homeRefreshFailed.setOnClickListener { activity.viewModel.refresh() }
            homeRefreshLayout.setOnRefreshListener { activity.viewModel.refresh() }

            homeRecyclerView.layoutManager = LinearLayoutManager(activity)
            homeRecyclerView.adapter = adapter
        }
    }

    private fun observe() {
        activity.viewModel.data.observe(activity, Observer {
            when (it?.state) {
                RepositoryLiveData.State.PROGRESS -> handleProgress()
                RepositoryLiveData.State.RESULT -> handleResult(it.result!!)
                RepositoryLiveData.State.OFFLINE -> handleOffline(it.result!!)
                RepositoryLiveData.State.COMPLETE -> handleComplete(it.result!!)
                RepositoryLiveData.State.ERROR -> handleError(it.error!!)
            }
        })
    }

    private fun handleProgress() {
        with(activity.binding) {
            visible(homeProgressBar)
            invisible(homeRefreshLayout, homeErrorContainer, homeRefreshFailed)
        }
    }

    private fun handleResult(result: NyTimesArticles) {
        with(activity.binding) {
            invisible(homeProgressBar, homeErrorContainer, homeRefreshFailed)
            visible(homeRefreshLayout)
        }
        adapter.articles = result.articles
    }

    private fun handleOffline(result: NyTimesArticles) {
        with(activity.binding) {
            invisible(homeProgressBar, homeErrorContainer)
            visible(homeRefreshLayout, homeRefreshFailed)
        }
        adapter.articles = result.articles
    }

    private fun handleComplete(result: NyTimesArticles) {
        with(activity.binding) {
            invisible(homeProgressBar, homeErrorContainer, homeRefreshFailed)
            visible(homeRefreshLayout)
            homeRefreshLayout.isRefreshing = false
        }
        adapter.articles = result.articles
    }

    private fun handleError(throwable: Throwable) {
        with(activity.binding) {
            invisible(homeProgressBar, homeRefreshLayout, homeRefreshFailed)
            visible(homeErrorContainer)
        }
    }
}
