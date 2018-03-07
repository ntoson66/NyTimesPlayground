package com.hdeva.nytimes.arch.di

import com.hdeva.nytimes.NyTimesApp
import com.hdeva.nytimes.arch.di.injectors.ActivityInjectorModule
import com.hdeva.nytimes.arch.di.injectors.ApplicationInjectorModule
import com.hdeva.nytimes.arch.di.modules.CommonModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationInjectorModule::class,
    ActivityInjectorModule::class,
    CommonModule::class
])
interface ApplicationComponent : AndroidInjector<NyTimesApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<NyTimesApp>()

}
