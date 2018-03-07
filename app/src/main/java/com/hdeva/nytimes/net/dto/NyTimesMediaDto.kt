package com.hdeva.nytimes.net.dto

import com.squareup.moshi.Json

data class NyTimesMediaDto(
        val type: String?,
        val subtype: String?,
        val caption: String?,
        val copyright: String?,
        val approved_for_syndication: Int?,
        @Json(name = "media-metadata")
        val media_metadata: List<NyTimesMediaMetaDataDto>?
)
