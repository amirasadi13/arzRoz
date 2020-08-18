package com.example.amamoneyprices.di

import com.example.amamoneyprices.BASE_URL
import com.example.amamoneyprices.BuildConfig
import com.example.amamoneyprices.remote.ApiService
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun provideRetrofit(okHttpClient: OkHttpClient , moshi: Moshi) : Retrofit{
    return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttpClient).build()
}

fun provideOkHttp(loggingInterceptor: LoggingInterceptor) : OkHttpClient{
    return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
}

fun provideMoshi():Moshi{
return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
}

fun provideLoggingInterceptor(): LoggingInterceptor {
    return  LoggingInterceptor.Builder()
        .loggable(BuildConfig.DEBUG)
        .setLevel(Level.BASIC)
        .log(Platform.INFO)
        .request("Request")
        .response("Response")
        .addHeader("version", BuildConfig.VERSION_NAME)
        .build()
}

fun provideApiService(retrofit: Retrofit) : ApiService {
    return retrofit.create(ApiService::class.java)
}