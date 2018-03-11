package com.hdeva.nytimes.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NyTimesMediaMetaData(
        val type: String,
        val format: String,
        val height: Int,
        val width: Int
) : Parcelable
