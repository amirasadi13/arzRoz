package com.example.amamoneyprices.model


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    @Json(name = "Name")
    var name: String?,
    @Json(name = "Rate")
    var rate: String?
) : Parcelable