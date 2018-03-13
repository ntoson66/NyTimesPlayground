package com.hdeva.nytimes.service

import android.support.annotation.VisibleForTesting
import com.hdeva.nytimes.model.NyTimesArticle
import com.hdeva.nytimes.model.NyTimesMediaMetaData

class ArticleImageExtractor {

    companion object {
        private const val SQUARE_320 = "square320"
    }

    fun extractSquare320(article: NyTimesArticle): NyTimesMediaMetaData? = doFilter(article, SQUARE_320)

    @VisibleForTesting
    internal fun doFilter(article: NyTimesArticle, filter: String): NyTimesMediaMetaData? {
        return article.media
                ?.firstOrNull()
                ?.mediaMetadata
                ?.firstOrNull { it.format == filter }
    }
}
