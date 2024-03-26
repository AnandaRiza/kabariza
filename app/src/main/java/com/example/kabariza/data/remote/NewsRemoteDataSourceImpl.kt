package com.example.kabariza.data.remote

import NewsResponse
import android.app.Service
import com.example.kabariza.data.NewsService
import com.example.kabariza.utils.Constant
import retrofit2.Response
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val service: NewsService
): NewsRemoteDataSource {
    override suspend fun getDataNews(): Response<NewsResponse> {
        return service.getNews("us","sport",Constant.API_KEY )
    }

}