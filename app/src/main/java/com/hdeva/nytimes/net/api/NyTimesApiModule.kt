package com.hdeva.nytimes.net.api

import com.hdeva.nytimes.net.NetworkModule
import com.hdeva.nytimes.net.converter.NyTimesArticlesConverter
import com.hdeva.nytimes.net.converter.SafeConverter
import com.hdeva.nytimes.net.dto.NyTimesMediaDto
import com.hdeva.nytimes.net.interceptor.NyTimesApiKeyInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module(includes = [NetworkModule::class])
class NyTimesApiModule {

    companion object {
        private const val NY_TIMES_API = "https://api.nytimes.com/svc/"
    }

    @Provides
    @Named(NY_TIMES_API)
    fun provideNyTimesMoshi(builder: Moshi.Builder): Moshi {
        addSafeConverters(builder)
        return builder
                .add(NyTimesArticlesConverter())
                .build()
    }

    private fun addSafeConverters(builder: Moshi.Builder) {
        val cleanMoshi = builder.build()
        val type = Types.newParameterizedType(List::class.java, NyTimesMediaDto::class.java)
        val adapter = cleanMoshi.adapter<List<NyTimesMediaDto>>(type)
        builder.add(type, SafeConverter<List<NyTimesMediaDto>>(adapter, emptyList()))
    }

    @Provides
    @Named(NY_TIMES_API)
    fun provideNyTimesOkHttpClient(builder: OkHttpClient.Builder, apiKeyInterceptor: NyTimesApiKeyInterceptor): OkHttpClient {
        return builder
                .addInterceptor(apiKeyInterceptor)
                .build()
    }

    @Provides
    @Named(NY_TIMES_API)
    fun provideNyTimesRetrofit(@Named(NY_TIMES_API) okHttpClient: OkHttpClient, @Named(NY_TIMES_API) moshi: Moshi): Retrofit {
        return Retrofit.Builder()
                .baseUrl(NY_TIMES_API)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okHttpClient)
                .build()
    }

    @Provides
    fun provideNyTimesApi(@Named(NY_TIMES_API) retrofit: Retrofit): NyTimesApi {
        return retrofit.create(NyTimesApi::class.java)
    }
}
