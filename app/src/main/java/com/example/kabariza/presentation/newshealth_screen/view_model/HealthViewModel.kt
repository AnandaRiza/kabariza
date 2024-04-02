package com.example.kabariza.presentation.newshealth_screen.view_model

import NewsResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kabariza.data.remote.NewsRemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HealthViewModel @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource) :
    ViewModel() {
    private val _homeNewsHealth = MutableLiveData<NewsResponse>()
    private val _homeNewsHealthError = MutableLiveData<String>()

    val homeHealthNews: LiveData<NewsResponse>
        get() = _homeNewsHealth

    val homeHealthNewsError: LiveData<String>
        get() = _homeNewsHealthError


    fun getNewsHealth() = viewModelScope.launch(Dispatchers.IO) {
        newsRemoteDataSource.getDataNewsHealth().let {
            if(it.isSuccessful){
                _homeNewsHealth.postValue(it.body())
            }
            else{
                _homeNewsHealthError.postValue(it.message())
            }

        }
    }

}