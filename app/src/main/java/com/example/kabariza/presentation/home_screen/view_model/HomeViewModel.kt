package com.example.kabariza.presentation.home_screen.view_model

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
class HomeViewModel @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource

) : ViewModel() {

    private val _newsMenu = MutableLiveData<NewsResponse>()
    private val _newsMenuError = MutableLiveData<String>()
    val newsMenu: LiveData<NewsResponse>
        get() = _newsMenu

    fun getNewsMenusSport() = viewModelScope.launch(Dispatchers.IO){
        newsRemoteDataSource.getDataNews().let {
            if (it.isSuccessful){
                _newsMenu.postValue(it.body())

            }else{
                _newsMenuError.postValue(it.message())
            }
        }
    }


}