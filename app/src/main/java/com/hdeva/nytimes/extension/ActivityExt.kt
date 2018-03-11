package com.hdeva.nytimes.extension

import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.enableActionBarBack() {
    supportActionBar?.let {
        it.setDisplayShowHomeEnabled(true)
        it.setDisplayHomeAsUpEnabled(true)
    }
}
