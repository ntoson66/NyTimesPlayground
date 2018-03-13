package com.hdeva.nytimes.net.converter

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import junit.framework.Assert.assertEquals
import org.junit.Test


class SafeConverterTest {

    @Test(expected = JsonDataException::class)
    fun test_default_converter_fails_on_mismatch() {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        val unexpectedString = "\"this is something unexpected\""

        // throws JsonDataException
        adapter.fromJson(unexpectedString)
    }

    @Test
    fun test_when_safe_converter_receives_correct_input() {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        val sut = SafeConverter<List<String>>(adapter, emptyList())

        val json = "[\"string1\",\"string2\",\"string3\"]"
        val list = sut.fromJson(json)

        assertEquals(list.size, 3)
        assertEquals(list[1], "string2")
    }

    @Test
    fun test_when_safe_converter_mismatches_and_falls_back_to_default() {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        val sut = SafeConverter<List<String>>(adapter, emptyList())

        val unexpectedString = "\"this is something unexpected\""
        val listFromString = sut.fromJson(unexpectedString)
        assertEquals(listFromString, emptyList<String>())

        val unexpectedInt = "\"123123\""
        val listFromInt = sut.fromJson(unexpectedInt)
        assertEquals(listFromInt, emptyList<String>())

        val unexpectedDouble = "\"123.321\""
        val listFromDouble = sut.fromJson(unexpectedDouble)
        assertEquals(listFromDouble, emptyList<String>())
    }
}
