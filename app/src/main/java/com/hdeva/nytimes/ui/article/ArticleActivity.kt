package com.hdeva.nytimes.ui.article

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hdeva.nytimes.R
import com.hdeva.nytimes.arch.base.BaseActivity
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
    lateinit var articleActivity: ArticleActivity

    private lateinit var article: NyTimesArticle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        enableActionBarBack()
        article = intent.getParcelableExtra(ARTICLE_KEY)
    }

}
