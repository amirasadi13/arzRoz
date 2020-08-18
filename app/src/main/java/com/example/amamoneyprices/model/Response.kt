package com.example.amamoneyprices.model


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(
    @Json(name = "Currency")
    val currency: List<Currency>?,
    @Json(name = "Gold")
    val gold: List<Gold>,
    @Json(name = "Item")
    val item: List<Item>,
    @Json(name = "LastModified")
    val lastModified: String
) : Parcelable