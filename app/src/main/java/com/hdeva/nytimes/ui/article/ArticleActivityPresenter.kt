package com.hdeva.nytimes.ui.article

import android.databinding.DataBindingUtil
import com.hdeva.nytimes.R
import com.hdeva.nytimes.extension.enableActionBarBack
import com.hdeva.nytimes.model.NyTimesArticle
import com.hdeva.nytimes.service.WebHelper
import javax.inject.Inject

class ArticleActivityPresenter @Inject constructor(
        private val activity: ArticleActivity,
        private val webHelper: WebHelper) {

    fun create() {
        with(activity) {
            binding = DataBindingUtil.setContentView(this, R.layout.activity_article)
            enableActionBarBack()
        }

        with(activity.binding) {
            articleTitle.text = activity.article.title
            articleAbstract.text = activity.article.abstract
            articleShowButton.setOnClickListener { openInBrowser(activity.article) }
        }

        webHelper.connect(activity)
    }

    fun destroy() {
        webHelper.disconnect(activity)
    }

    private fun openInBrowser(article: NyTimesArticle) {
        webHelper.open(activity, article.url)
    }
}
