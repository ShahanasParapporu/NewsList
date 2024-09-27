package com.example.mvvmpass

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmpass.api.RetrofitClient
import com.example.mvvmpass.models.NewsDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {

    val serviceSetterGetter = MutableLiveData<NewsDataResponse>()

    fun getServicesApiCall(): MutableLiveData<NewsDataResponse> {

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object: Callback<NewsDataResponse> {
            override fun onFailure(call: Call<NewsDataResponse>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<NewsDataResponse>,
                response: Response<NewsDataResponse>
            ) {
                serviceSetterGetter.value = response.body()
            }
        })

        return serviceSetterGetter
    }



}