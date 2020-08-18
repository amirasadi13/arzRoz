package com.example.amamoneyprices.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.amamoneyprices.model.Response
import com.example.amamoneyprices.remote.ApiRepository
import com.example.amamoneyprices.remote.errorhandeling.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val apiRepository: ApiRepository) : ViewModel() {

    val hasError = MutableLiveData(false)
    val isShowLoading = MutableLiveData(false)
    val list = MutableLiveData <Resource<Response>>(Resource.loading())

    init {

        fetchData()

    }

    fun tryFetch() {
        if (hasError.value!!) {
            fetchData()
        }
    }


    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = apiRepository.getPrices()
            list.postValue(response)
        }
    }
}