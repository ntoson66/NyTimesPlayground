package com.hdeva.nytimes.ui.article

import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import com.hdeva.nytimes.R
import com.hdeva.nytimes.extension.enableActionBarBack
import com.hdeva.nytimes.model.NyTimesArticle
import javax.inject.Inject

class ArticleActivityPresenter @Inject constructor(private val activity: ArticleActivity) {

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
    }

    private fun openInBrowser(article: NyTimesArticle) {
        activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(article.url)))
    }
}
