package com.coderbee.veganloversclub.di

import com.coderbee.veganloversclub.data.api.ApiConstants
import com.coderbee.veganloversclub.data.api.MealApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MealApiModule {

    @Provides
    @Singleton
    fun provideApi(builder:Retrofit.Builder): MealApi{
        return builder
            .build()
            .create(MealApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }
}