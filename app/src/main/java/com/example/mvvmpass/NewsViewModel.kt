package com.example.mvvmpass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmpass.models.NewsDataResponse

class NewsViewModel : ViewModel() {

    var getService : MutableLiveData<NewsDataResponse>?= null

    private val _getdata = MutableLiveData<NewsDataResponse.Article>()
    public val getData : MutableLiveData<NewsDataResponse.Article> = _getdata

    fun getUser() : LiveData<NewsDataResponse>?{
        getService = Repository.getServicesApiCall()
        return getService
    }


    fun setFacilityDetails(details: NewsDataResponse.Article) {
        getData.value = details as NewsDataResponse.Article

    }


}