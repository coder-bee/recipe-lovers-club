package com.coderbee.veganloversclub.networking.datasource

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object MealDBApiFactory {

    private fun buildOkHttp(): OkHttpClient {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun buildRetrofit(baseURL: String, okHttpClient: OkHttpClient = buildOkHttp()): Retrofit {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }
        val converterFactory = json.asConverterFactory(contentType)
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .baseUrl(baseURL)
            .build()
    }

    fun create(baseUrl: String, retrofit: Retrofit = buildRetrofit(baseUrl)) : MealDBApi =
        retrofit.create(MealDBApi::class.java)

}