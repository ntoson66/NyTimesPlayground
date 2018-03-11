package com.hdeva.nytimes.arch.di.injectors

import com.hdeva.nytimes.ui.article.ArticleActivity
import com.hdeva.nytimes.ui.home.HomeActivity
import com.hdeva.nytimes.ui.home.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityInjectorModule {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    fun contributeArticleActivity(): ArticleActivity
}
