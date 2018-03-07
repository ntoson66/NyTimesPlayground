package com.hdeva.nytimes.ui.adapter.holder

import android.support.v7.widget.RecyclerView
import com.hdeva.nytimes.databinding.ItemNyTimesArticleBinding
import com.hdeva.nytimes.model.NyTimesArticle

class NyTimesArticleViewHolder(val binding: ItemNyTimesArticleBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(article: NyTimesArticle) {
        binding.itemNyTimesArticleTitle.text = article.title
    }
}
