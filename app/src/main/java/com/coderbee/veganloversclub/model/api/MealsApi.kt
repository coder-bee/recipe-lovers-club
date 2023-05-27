package com.coderbee.veganloversclub.model.api

import androidx.compose.foundation.layout.*
import com.coderbee.veganloversclub.model.response.MealCategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealsWebService {
    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }
    suspend fun getMeals(): MealCategoriesResponse {
        return api.getMeals()
    }

    interface MealsApi {
        @GET("categories.php")
        suspend fun getMeals(): MealCategoriesResponse
    }
}