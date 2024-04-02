package com.example.kabariza.presentation.newstech_screen.view_model

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
class NewsTechViewModel @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource)
    : ViewModel() {
    private val _homeNewsTech = MutableLiveData<NewsResponse>()
    private val _homeNewsTechError = MutableLiveData<String>()

    val homeTechNews: LiveData<NewsResponse>
        get() = _homeNewsTech

    val homeNewsTechError: LiveData<String>
        get() = _homeNewsTechError


    fun getTechNews() = viewModelScope.launch(Dispatchers.IO) {
        newsRemoteDataSource.getDataNews().let {
            if(it.isSuccessful){
                _homeNewsTech.postValue(it.body())
            }
            else{
                _homeNewsTechError.postValue(it.message())
            }

        }
    }
}