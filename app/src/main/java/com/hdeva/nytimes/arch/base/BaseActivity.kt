package com.hdeva.nytimes.arch.base

import com.hdeva.nytimes.R
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onContentChanged() {
        super.onContentChanged()
        setSupportActionBar(findViewById(R.id.support_toolbar))
    }
}
