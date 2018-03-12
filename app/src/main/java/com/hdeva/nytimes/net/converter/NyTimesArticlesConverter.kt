package com.hdeva.nytimes.net.converter

import com.hdeva.nytimes.model.NyTimesArticle
import com.hdeva.nytimes.model.NyTimesArticles
import com.hdeva.nytimes.model.NyTimesMedia
import com.hdeva.nytimes.model.NyTimesMediaMetaData
import com.hdeva.nytimes.net.dto.NyTimesArticleDto
import com.hdeva.nytimes.net.dto.NyTimesArticlesDto
import com.hdeva.nytimes.net.dto.NyTimesMediaDto
import com.hdeva.nytimes.net.dto.NyTimesMediaMetaDataDto
import com.squareup.moshi.FromJson

class NyTimesArticlesConverter {

    @FromJson
    fun fromJson(dto: NyTimesArticlesDto): NyTimesArticles {
        return NyTimesArticles(
                status = dto.status ?: "",
                copyright = dto.copyright ?: "",
                numResults = dto.num_results ?: 0,
                articles = dto.results?.map { mapDto(it) }?.toMutableList() ?: mutableListOf()
        )
    }

    private fun mapDto(dto: NyTimesArticleDto): NyTimesArticle {
        return NyTimesArticle(
                url = dto.url ?: "",
                adxKeywords = dto.adx_keywords ?: "",
                column = dto.column ?: "",
                section = dto.section ?: "",
                byline = dto.byline ?: "",
                type = dto.type ?: "",
                title = dto.title ?: "",
                abstract = dto.abstract ?: "",
                publishedDate = dto.published_date ?: "",
                source = dto.source ?: "",
                id = dto.id ?: 0L,
                assetId = dto.asset_id ?: 0L,
                views = dto.views ?: 0L,
                media = dto.media?.map { mapDto(it) } ?: emptyList()
        )
    }

    private fun mapDto(dto: NyTimesMediaDto): NyTimesMedia {
        return NyTimesMedia(
                type = dto.type ?: "",
                subtype = dto.subtype ?: "",
                caption = dto.caption ?: "",
                copyright = dto.copyright ?: "",
                approvedForSyndication = dto.approved_for_syndication ?: 0,
                mediaMetadata = dto.media_metadata?.map { mapDto(it) } ?: emptyList()
        )
    }

    private fun mapDto(dto: NyTimesMediaMetaDataDto): NyTimesMediaMetaData {
        return NyTimesMediaMetaData(
                url = dto.url ?: "",
                format = dto.format ?: "",
                height = dto.height ?: 0,
                width = dto.width ?: 0
        )
    }
}
