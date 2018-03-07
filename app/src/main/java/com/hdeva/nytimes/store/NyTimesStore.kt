package com.hdeva.nytimes.store

import com.hdeva.nytimes.model.NyTimesArticles
import io.paperdb.Book
import javax.inject.Inject

class NyTimesStore @Inject constructor(private val book: Book) {

    companion object {
        private const val DEFAULT_ARTICLE_KEY = "defaultArticles"
    }

    fun hasDefaultArticles(): Boolean {
        return book.contains(DEFAULT_ARTICLE_KEY)
    }

    fun getDefaultArticles(): NyTimesArticles {
        return book.read(DEFAULT_ARTICLE_KEY)
    }

    fun setDefaultArticles(articles: NyTimesArticles) {
        book.write(DEFAULT_ARTICLE_KEY, articles)
    }
}
