package com.example.kabariza.module


import com.example.kabariza.data.NewsService
import com.example.kabariza.data.remote.NewsRemoteDataSource
import com.example.kabariza.data.remote.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDataSource(service : NewsService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(service)
    }
}