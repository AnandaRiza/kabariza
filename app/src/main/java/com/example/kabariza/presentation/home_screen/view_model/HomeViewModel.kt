package com.example.kabariza.presentation.home_screen.view_model

import androidx.lifecycle.ViewModel
import com.example.kabariza.data.remote.NewsRemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRemoteDataSource: NewsRemoteDataSource
) : ViewModel() {



}