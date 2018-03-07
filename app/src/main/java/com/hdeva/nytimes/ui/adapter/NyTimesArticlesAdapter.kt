package com.hdeva.nytimes.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hdeva.nytimes.R
import com.hdeva.nytimes.databinding.ItemNyTimesArticleBinding
import com.hdeva.nytimes.model.NyTimesArticle
import com.hdeva.nytimes.ui.adapter.holder.NyTimesArticleViewHolder
import javax.inject.Inject

class NyTimesArticlesAdapter @Inject constructor() : RecyclerView.Adapter<NyTimesArticleViewHolder>() {

    init {
        setHasStableIds(true)
    }

    var articles: List<NyTimesArticle> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NyTimesArticleViewHolder {
        val binding = DataBindingUtil.inflate<ItemNyTimesArticleBinding>(LayoutInflater.from(parent?.context), R.layout.item_ny_times_article, parent, false)
        return NyTimesArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NyTimesArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    override fun getItemId(position: Int): Long = articles[position].id
}
