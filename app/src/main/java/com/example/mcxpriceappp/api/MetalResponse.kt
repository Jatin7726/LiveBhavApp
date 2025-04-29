package com.example.mcxpriceappp.api

import com.google.gson.annotations.SerializedName

data class MetalResponse(
    val status: String,
    val currency: String,
    val unit: String,
    val metals: Metals,
    val currencies: Currencies,
    val timestamps: Timestamps
)
data class Currencies(
    @SerializedName("USD") val usd: Double,
    @SerializedName("EUR") val eur: Double,
    @SerializedName("AED") val aed: Double
)

data class Metals(
    @SerializedName("mcx_gold") val mcxGold: Double,
    @SerializedName("mcx_silver") val mcxSilver: Double,
    @SerializedName("mcx_gold_am") val mcxGoldAM: Double,
    @SerializedName("mcx_gold_pm") val mcxGoldPM: Double,
    @SerializedName("mcx_silver_am") val mcxSilverAM: Double,
    @SerializedName("mcx_silver_pm") val mcxSilverPM: Double,
    @SerializedName("ibja_gold") val ibjaGold: Double
)

data class Timestamps(
    val metal: String,
    val currency: String
)