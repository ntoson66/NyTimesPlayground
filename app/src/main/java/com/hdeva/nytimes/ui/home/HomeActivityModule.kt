package com.hdeva.nytimes.ui.home

import android.arch.lifecycle.ViewModel
import com.hdeva.nytimes.arch.viewmodel.ViewModelKey
import com.hdeva.nytimes.net.api.NyTimesApiModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [NyTimesApiModule::class])
abstract class HomeActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    abstract fun bindViewModel(viewModel: HomeActivityViewModel): ViewModel
}
