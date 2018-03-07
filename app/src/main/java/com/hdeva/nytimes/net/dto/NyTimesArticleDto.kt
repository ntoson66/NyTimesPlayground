package com.hdeva.nytimes.net.dto

class NyTimesArticleDto(
        val url: String?,
        val adx_keywords: String?,
        val column: String?,
        val section: String?,
        val byline: String?,
        val type: String?,
        val title: String?,
        val abstract: String?,
        val published_date: String?,
        val source: String?,
        val id: Long?,
        val asset_id: Long?,
        val views: Long?,
        val des_facet: List<String>?,
        val org_facet: List<String>?,
        val per_facet: List<String>?,
        val geo_facet: List<String>?,
        val media: NyTimesMediaDto?
)
