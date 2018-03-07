package com.hdeva.nytimes.store

import io.paperdb.Book
import javax.inject.Inject

class NyTimesStore @Inject constructor(private val book: Book) {
}
