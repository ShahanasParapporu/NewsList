package com.example.mvvmpass.api

import com.example.mvvmpass.models.NewsDataResponse
import com.example.mvvmpass.util.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface{

    @GET("v2/top-headlines")
    fun getServices(@Query("country") countryCode: String = "us",
                    @Query("page") pageNumber: Int = 1,
                    @Query("apiKey") apiKey: String = API_KEY) : Call<NewsDataResponse>

}
