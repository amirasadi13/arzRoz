package com.example.amamoneyprices.model


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Gold(
    @Json(name = "Buy")
    var buy: Int?,
    @Json(name = "Coin")
    var coin: String?,
    @Json(name = "Sell")
    var sell: Int?
) : Parcelable