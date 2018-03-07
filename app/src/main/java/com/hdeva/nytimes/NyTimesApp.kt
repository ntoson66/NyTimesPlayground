package com.hdeva.nytimes

import com.hdeva.nytimes.arch.di.DaggerApplicationComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.paperdb.Paper

class NyTimesApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }

    override fun onCreate() {
        Paper.init(this)
        AndroidThreeTen.init(this)
        super.onCreate()
    }
}
