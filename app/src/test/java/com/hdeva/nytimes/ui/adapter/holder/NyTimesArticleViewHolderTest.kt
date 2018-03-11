package com.hdeva.nytimes.ui.adapter.holder

import android.app.Activity
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import com.hdeva.nytimes.R
import com.hdeva.nytimes.databinding.ItemNyTimesArticleBinding
import com.hdeva.nytimes.model.NyTimesArticle
import junit.framework.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class NyTimesArticleViewHolderTest {

    @Test
    fun test_ui_in_correct_state() {
        val inflater = LayoutInflater.from(Robolectric.buildActivity(Activity::class.java).get())
        val binding = DataBindingUtil.inflate<ItemNyTimesArticleBinding>(inflater, R.layout.item_ny_times_article, null, false)
        val sut = NyTimesArticleViewHolder(binding)
        sut.bind(NyTimesArticle(
                url = "https://google.com",
                adxKeywords = "",
                column = "",
                section = "",
                byline = "byline",
                type = "",
                title = "title",
                abstract = "abstract",
                publishedDate = "1970-01-01",
                source = "",
                id = 0,
                assetId = 0,
                views = 0,
                media = null
        ))

        Assert.assertEquals(binding.itemNyTimesArticleTitle.text, "title")
        Assert.assertEquals(binding.itemNyTimesArticleByline.text, "byline")
        Assert.assertEquals(binding.itemNyTimesArticleDate.text, "1970-01-01")
    }
}
