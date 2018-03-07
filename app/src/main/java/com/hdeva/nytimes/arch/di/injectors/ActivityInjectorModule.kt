package com.hdeva.nytimes.arch.di.injectors

import com.hdeva.nytimes.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityInjectorModule {

    @ContributesAndroidInjector
    fun ContributeHomeActivity(): HomeActivity
}
