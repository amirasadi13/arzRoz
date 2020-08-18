package com.example.amamoneyprices.remote

import com.example.amamoneyprices.model.Response
import retrofit2.http.GET

interface ApiService {

    @GET("json")
    suspend fun getPrices() : Response

}