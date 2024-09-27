package com.example.mvvmpass.adapters

import com.example.mvvmpass.models.NewsDataResponse

interface AdapterClickListener {

    fun onItemClicked(details: NewsDataResponse.Article)
}