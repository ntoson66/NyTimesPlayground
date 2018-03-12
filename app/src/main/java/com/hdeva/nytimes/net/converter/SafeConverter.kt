package com.hdeva.nytimes.net.converter

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

/**
 * Another day, another dumb API.
 * In a few cases, where array is expected in the JSON response,
 * the API instead responds with any empty string (""). This
 * is not a good use case for the strict Moshi serializers,
 * so it has to be worked around by providing a fallback value.
 *
 * Based on: https://github.com/square/moshi/blob/af09de142d9bb57057a80362104dcf7ff051db64/examples/src/main/java/com/squareup/moshi/recipes/DefaultOnDataMismatchAdapter.java
 */
class SafeConverter<T>(
        private val delegate: JsonAdapter<T>,
        private val defaultValue: T) : JsonAdapter<T>() {

    override fun fromJson(reader: JsonReader?): T {
        val jsonValue = reader?.readJsonValue()
        return try {
            delegate.fromJsonValue(jsonValue)
        } catch (t: Throwable) {
            defaultValue
        }
    }

    override fun toJson(writer: JsonWriter?, value: T) {
        delegate.toJson(writer, value)
    }
}
