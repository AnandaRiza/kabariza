package com.example.kabariza.presentation.newssport_screen.view_model

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
class NewsSportViewModel @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource

) : ViewModel() {

    private val _homeNewsSport = MutableLiveData<NewsResponse>()
    private val _homeNewsSportError = MutableLiveData<String>()
    val homeNewsSport: LiveData<NewsResponse>
        get() = _homeNewsSport

    val homeNewsSportError : LiveData<String>
        get() = _homeNewsSportError


    fun getSportNews() = viewModelScope.launch(Dispatchers.IO){
        newsRemoteDataSource.getDataNewsSport().let {
            if (it.isSuccessful){
                _homeNewsSport.postValue(it.body())

            }else{
                _homeNewsSportError.postValue(it.message())
            }
        }
    }


}