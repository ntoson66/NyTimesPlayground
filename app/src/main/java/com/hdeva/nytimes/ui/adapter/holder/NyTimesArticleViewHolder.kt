package com.hdeva.nytimes.ui.adapter.holder

import android.support.v7.widget.RecyclerView
import com.hdeva.nytimes.databinding.ItemNyTimesArticleBinding
import com.hdeva.nytimes.extension.setNetworkImage
import com.hdeva.nytimes.model.NyTimesArticle
import com.hdeva.nytimes.service.ArticleImageExtractor
import com.hdeva.nytimes.ui.article.ArticleActivity

class NyTimesArticleViewHolder(val binding: ItemNyTimesArticleBinding) : RecyclerView.ViewHolder(binding.root) {

    private val extractor: ArticleImageExtractor = ArticleImageExtractor()
    private lateinit var article: NyTimesArticle

    init {
        binding.itemNyTimesArticleContainer.setOnClickListener { openArticle() }
    }

    fun bind(article: NyTimesArticle) {
        this.article = article
        with(binding) {
            val url = extractor.extractSquare320(article)?.url
            itemNyTimesArticleImage.setNetworkImage(url)
            itemNyTimesArticleTitle.text = article.title
            itemNyTimesArticleByline.text = article.byline
            itemNyTimesArticleDate.text = article.publishedDate
        }
    }

    private fun openArticle() {
        ArticleActivity.showArticle(itemView.context, article)
    }
}
