package com.hdeva.nytimes.arch.di.injectors

import android.content.Context
import com.hdeva.nytimes.NyTimesApp
import dagger.Binds
import dagger.Module

@Module
interface ApplicationInjectorModule {

    @Binds
    fun bindApplication(app: NyTimesApp): Context
}
