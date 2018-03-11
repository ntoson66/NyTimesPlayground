package com.hdeva.nytimes.ui.article

import com.hdeva.nytimes.model.NyTimesArticle
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ArticleActivityPresenterTest {

    @Test
    fun test_ui_in_correct_state() {
        val activity = Robolectric.setupActivity(ArticleActivity::class.java)
        activity.article = NyTimesArticle(
                url = "https://google.com",
                adxKeywords = "",
                column = "",
                section = "",
                byline = "byline",
                type = "",
                title = "title",
                abstract = "abstract",
                publishedDate = "",
                source = "",
                id = 0,
                assetId = 0,
                views = 0,
                media = null
        )

        assertEquals(activity.binding.articleTitle.text, "title")
        assertEquals(activity.binding.articleAbstract.text, "abstract")
    }
}
