package com.hdeva.nytimes.ui.article

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hdeva.nytimes.arch.base.BaseActivity
import com.hdeva.nytimes.databinding.ActivityArticleBinding
import com.hdeva.nytimes.model.NyTimesArticle
import javax.inject.Inject

class ArticleActivity : BaseActivity() {

    companion object {
        private const val ARTICLE_KEY = "article"

        fun showArticle(context: Context, article: NyTimesArticle) {
            val intent = Intent(context, ArticleActivity::class.java)
            intent.putExtra(ARTICLE_KEY, article)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: ArticleActivityPresenter
    lateinit var article: NyTimesArticle
    lateinit var binding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        article = intent.getParcelableExtra(ARTICLE_KEY)
        presenter.create()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

}
