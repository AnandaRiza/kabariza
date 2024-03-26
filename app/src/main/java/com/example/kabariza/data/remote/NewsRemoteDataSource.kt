package com.example.kabariza.data.remote

import NewsResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getDataNews(): Response<NewsResponse>

}