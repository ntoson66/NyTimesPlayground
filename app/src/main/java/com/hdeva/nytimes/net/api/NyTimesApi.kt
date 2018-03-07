package com.hdeva.nytimes.net.api

import com.hdeva.nytimes.model.NyTimesArticles
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NyTimesApi {

    @GET("mostpopular/v2/mostviewed/{section}/{period}.json")
    fun getNyTimesArticles(
            @Path("section") section: String,
            @Path("period") period: String,
            @Query("offset") offset: Int)
            : Call<NyTimesArticles>

}
