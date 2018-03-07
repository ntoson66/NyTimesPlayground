package com.hdeva.nytimes.extension

import android.view.View

fun <V : View?> visible(vararg views: V) {
    views.forEach { it?.visibility = View.VISIBLE }
}

fun <V : View?> invisible(vararg views: V) {
    views.forEach { it?.visibility = View.INVISIBLE }
}

fun <V : View?> gone(vararg views: V) {
    views.forEach { it?.visibility = View.GONE }
}
