package com.hdeva.nytimes.net.dto

data class NyTimesArticlesDto(
        val status: String?,
        val copyright: String?,
        val num_results: Int?,
        val results: List<NyTimesArticleDto>?
)
