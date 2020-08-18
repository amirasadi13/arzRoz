package com.example.amamoneyprices.model


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Currency(
    @Json(name = "Buy")
    val buy: Int?,
    @Json(name = "Code")
    val code: String?,
    @Json(name = "Currency")
    val currency: String?,
    @Json(name = "Sell")
    val sell: Int?
) : Parcelable