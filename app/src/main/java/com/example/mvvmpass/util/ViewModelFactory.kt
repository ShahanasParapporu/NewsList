package com.example.mvvmpass.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpass.NewsViewModel

class ViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(NewsViewModel::class.java)){

            return NewsViewModel() as T
        }

        throw(Throwable("Unknown class"))
    }
}