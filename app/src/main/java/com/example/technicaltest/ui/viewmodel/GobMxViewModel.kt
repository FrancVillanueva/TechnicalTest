package com.example.technicaltest.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.technicaltest.ui.model.ApiResponse
import com.example.technicaltest.ui.model.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.technicaltest.ui.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GobMxViewModel : ViewModel() {

    private val _apiResponse = MutableLiveData<ApiResponse>()
    val apiResponse: LiveData<ApiResponse> get() = _apiResponse

    private val apiService = getRetrofit().create(ApiService::class.java)

    fun fetchData() {
        val call: Call<ApiResponse> = apiService.getResponse("https://api.datos.gob.mx/v1/gobmx.facts/")

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    _apiResponse.value = response.body()
                } else {
                    // Manejar error
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                // Manejar error
            }
        })
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.datos.gob.mx/v1/gobmx.facts/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getFilteredResults(query: String): List<Result> {
        val apiResponse = apiResponse.value
        return apiResponse?.results?.filter { result ->
            result.organization.contains(query, true)
        } ?: emptyList()
    }
}
