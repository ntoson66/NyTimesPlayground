package com.hdeva.nytimes.arch.di.modules

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.paperdb.Book
import io.paperdb.Paper

@Module
class CommonModule {

    @Provides
    fun provideDefaultBook(): Book = Paper.book()

    @Provides
    fun provideCleanMoshiBuilder(): Moshi.Builder = Moshi.Builder()

    @Provides
    fun provideCleanMoshi(builder: Moshi.Builder): Moshi = builder.build()
}
