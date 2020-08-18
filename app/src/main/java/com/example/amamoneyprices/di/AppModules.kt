package com.example.amamoneyprices.di

import com.example.amamoneyprices.remote.ApiRepository
import com.example.amamoneyprices.remote.errorhandeling.ResponseHandler
import com.example.amamoneyprices.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    single { provideApiService(get()) }
    single { provideLoggingInterceptor() }
    single { provideMoshi() }
    single { provideOkHttp(get()) }
    single { provideRetrofit(get(), get()) }
    single { ApiRepository(get(), get()) }
    single { ResponseHandler() }
}

val viewModelModules = module {

    viewModel { HomeViewModel(get()) }

}