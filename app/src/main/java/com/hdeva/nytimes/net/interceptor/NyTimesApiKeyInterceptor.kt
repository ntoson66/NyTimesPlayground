package com.hdeva.nytimes.net.interceptor

import android.content.Context
import com.hdeva.nytimes.R
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NyTimesApiKeyInterceptor @Inject constructor(private val context: Context) : Interceptor {

    companion object {
        private const val API_KEY_FIELD = "api-key"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request
                .url()
                .newBuilder()
                .addQueryParameter(API_KEY_FIELD, context.getString(R.string.ny_times_api_key))
                .build()
        val newRequest = request
                .newBuilder()
                .url(url)
                .build()
        return chain.proceed(newRequest)
    }
}
