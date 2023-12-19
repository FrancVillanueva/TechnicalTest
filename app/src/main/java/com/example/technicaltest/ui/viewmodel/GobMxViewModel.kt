package com.example.technicaltest.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.technicaltest.ui.model.ApiResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.technicaltest.ui.model.Result

class GobMxViewModel : ViewModel() {

    private val _apiResponse = MutableLiveData<ApiResponse>()
    val apiResponse: LiveData<ApiResponse> get() = _apiResponse

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.datos.gob.mx/v1/gobmx.facts/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getFilteredResults(query: String): List<Result> {
        return apiResponse.value?.results?.filter { result ->
            result.organization.contains(query, true)
        } ?: emptyList()
    }
}