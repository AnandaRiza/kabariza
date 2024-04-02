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
    override suspend fun getDataNewsHealth(): Response<NewsResponse> {
        return service.getNews("us",Constant.CATEGORY_HEALTH,Constant.API_KEY )
    }

    override suspend fun getDataNews(): Response<NewsResponse> {
        return service.getNews("","",Constant.API_KEY )
    }

    override suspend fun getDataNewsSport(): Response<NewsResponse> {
        return service.getNews("us",Constant.CATEGORY_SPORT,Constant.API_KEY )
    }

    override suspend fun getDataNewsTechnology(): Response<NewsResponse> {
        return service.getNews("us",Constant.CATEGORY_TECH,Constant.API_KEY )
    }

}