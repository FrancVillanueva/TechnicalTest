package com.example.technicaltest.ui.model

import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    fun getResponse(@Url url: String):List<Result>
}