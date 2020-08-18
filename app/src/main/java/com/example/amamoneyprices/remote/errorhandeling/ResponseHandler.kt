package com.example.amamoneyprices.remote.errorhandeling

import android.util.Log

import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ResponseHandler {
    private val TAG = "ResponseHandler"

    fun <T> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T> handleException(e: Exception): Resource<T> {
        Log.e(TAG, e.toString() );
        val message = when (e) {
            is HttpException -> "سرور دردسترس نیست"
            is SocketTimeoutException -> "خطا در برقراری ارتباط"
            is UnknownHostException -> "اینترنت متصل نیست"
            else -> "خطا در برقراری ارتباط مجددا تلاش نمایید"
        }

        return Resource.error(message)
    }
}