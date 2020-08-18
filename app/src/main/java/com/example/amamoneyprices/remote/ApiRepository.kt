package com.example.amamoneyprices.remote

import com.example.amamoneyprices.model.Response
import com.example.amamoneyprices.remote.errorhandeling.Resource
import com.example.amamoneyprices.remote.errorhandeling.ResponseHandler

class ApiRepository (private val apiService: ApiService,private val responseHandler: ResponseHandler) {

    suspend fun getPrices(): Resource<Response> {
        return try {
            responseHandler.handleSuccess(apiService.getPrices())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}