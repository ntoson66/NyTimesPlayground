package com.hdeva.nytimes.arch.viewmodel

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
