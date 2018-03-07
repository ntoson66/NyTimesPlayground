package com.hdeva.nytimes.net

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    companion object {
        private const val CACHE_SIZE_LIMIT = 10L * 1024L * 1024L
        private const val CONNECTION_TIMEOUT = 15L
        private const val READ_TIMEOUT = 60L
        private const val WRITE_TIMEOUT = 60L
    }

    @Provides
    fun provideCache(context: Context): Cache = Cache(context.cacheDir, CACHE_SIZE_LIMIT)

    @Provides
    fun provideOkHttpClientBuilder(cache: Cache): OkHttpClient.Builder = OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
}
