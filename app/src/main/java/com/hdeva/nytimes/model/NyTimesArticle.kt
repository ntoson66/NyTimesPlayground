package com.hdeva.nytimes.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NyTimesArticle(
        val url: String,
        val adxKeywords: String,
        val column: String,
        val section: String,
        val byline: String,
        val type: String,
        val title: String,
        val abstract: String,
        val publishedDate: String,
        val source: String,
        val id: Long,
        val assetId: Long,
        val views: Long,
        val media: List<NyTimesMedia>?
) : Parcelable
