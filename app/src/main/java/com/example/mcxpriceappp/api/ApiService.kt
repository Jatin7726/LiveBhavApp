package com.example.mcxpriceappp.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/latest")
    suspend fun getLatestPrices(
        @Query("api_key") apiKey: String,
        @Query("currency") currency: String,
        @Query("unit") unit: String
    ): MetalResponse
}

