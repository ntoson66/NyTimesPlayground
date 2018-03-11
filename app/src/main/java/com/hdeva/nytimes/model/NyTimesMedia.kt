package com.hdeva.nytimes.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NyTimesMedia(
        val type: String,
        val subtype: String,
        val caption: String,
        val copyright: String,
        val approvedForSyndication: Int,
        val mediaMetadata: List<NyTimesMediaMetaData> = emptyList()
) : Parcelable
