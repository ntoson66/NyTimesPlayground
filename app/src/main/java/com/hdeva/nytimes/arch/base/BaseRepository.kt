package com.hdeva.nytimes.arch.base

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import java.util.concurrent.TimeUnit

abstract class BaseRepository {

    protected fun <T> queue(call: Call<T>): Observable<T> {
        return Observable
                .fromCallable { execute(call) }
                .timeout(3, TimeUnit.MINUTES)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { Log.e(javaClass.simpleName, "Error while running request through repository", it) }
    }

    protected fun <T> execute(call: Call<T>): T {
        return try {
            val response = call.execute()
            if (response.isSuccessful) {
                val body: T? = response.body()
                if (body == null) {
                    throw RepositoryException("Null response received")
                } else {
                    return body
                }
            } else {
                throw RepositoryException(
                        "Error executing request: ${response.errorBody()?.string() ?: "null"}")
            }
        } catch (t: Throwable) {
            throw RepositoryException(t)
        }
    }

    inner class RepositoryException : Exception {

        constructor(message: String) : super(message)

        constructor(cause: Throwable) : super(cause)
    }
}
