package com.hdeva.nytimes.ui.adapter.holder

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import com.hdeva.nytimes.databinding.ItemNyTimesArticleBinding
import com.hdeva.nytimes.model.NyTimesArticle

class NyTimesArticleViewHolder(val binding: ItemNyTimesArticleBinding) : RecyclerView.ViewHolder(binding.root) {

    private var article: NyTimesArticle? = null

    init {
        binding.itemNyTimesArticleContainer.setOnClickListener { openArticle() }
    }

    fun bind(article: NyTimesArticle) {
        this.article = article
        with(binding) {
            itemNyTimesArticleTitle.text = article.title
        }
    }

    private fun openArticle() {
        binding.root.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(article?.url)))
    }
}
