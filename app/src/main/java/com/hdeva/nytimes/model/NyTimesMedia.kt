package com.hdeva.nytimes.model

data class NyTimesMedia(
        val type: String,
        val subtype: String,
        val caption: String,
        val copyright: String,
        val approvedForSyndication: Int,
        val mediaMetadata: List<NyTimesMediaMetaData> = emptyList()
)
