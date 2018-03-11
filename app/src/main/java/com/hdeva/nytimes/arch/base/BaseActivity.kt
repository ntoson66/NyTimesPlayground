package com.hdeva.nytimes.arch.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.view.MenuItem
import com.hdeva.nytimes.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onContentChanged() {
        super.onContentChanged()
        setSupportActionBar(findViewById(R.id.support_toolbar))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun <VM : ViewModel> getViewModel(viewModelKey: Class<VM>): VM {
        return ViewModelProviders.of(this, factory).get(viewModelKey)
    }
}
