package com.hdeva.nytimes.model

data class NyTimesArticles(
        val status: String,
        val copyright: String,
        val numResults: Int,
        val articles: MutableList<NyTimesArticle>
)
