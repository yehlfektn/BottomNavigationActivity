package com.csi.bottomnavigationactivity.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BBService {
    @GET("characters")
    fun fetchCharacters(): Call<List<Character>>
}