package com.hdeva.nytimes.extension

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setNetworkImage(url: String?) {
    try {
        setImageDrawable(null)

        Glide.with(this)
                .load(url)
                .into(this)
    } catch (t: Throwable) {
        Log.e("Glide", "Failed to load image with the following url: $url")
    }
}
