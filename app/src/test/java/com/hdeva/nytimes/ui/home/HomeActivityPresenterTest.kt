package com.hdeva.nytimes.ui.home

import android.view.View
import com.hdeva.nytimes.model.NyTimesArticles
import com.hdeva.nytimes.ui.adapter.NyTimesArticlesAdapter
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HomeActivityPresenterTest {

    @Test
    fun test_visibility_changes() {
        val activity = Robolectric.setupActivity(HomeActivity::class.java)

        val sut = HomeActivityPresenter(activity, NyTimesArticlesAdapter())

        sut.handleProgress()
        assertEquals(activity.binding.homeProgressBar.visibility, View.VISIBLE)
        assertEquals(activity.binding.homeRefreshLayout.visibility, View.INVISIBLE)

        sut.handleResult(NyTimesArticles("", "", 0, mutableListOf()))
        assertEquals(activity.binding.homeRefreshLayout.visibility, View.VISIBLE)
        assertEquals(activity.binding.homeProgressBar.visibility, View.INVISIBLE)
        assertTrue(activity.binding.homeRefreshLayout.isRefreshing)

        sut.handleError(Throwable())
        assertEquals(activity.binding.homeErrorContainer.visibility, View.VISIBLE)
        assertEquals(activity.binding.homeProgressBar.visibility, View.INVISIBLE)
    }
}
