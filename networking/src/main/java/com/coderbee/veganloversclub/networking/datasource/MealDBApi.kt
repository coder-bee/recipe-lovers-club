package com.coderbee.veganloversclub.networking.datasource

import com.coderbee.veganloversclub.networking.model.CategoryResponse
import com.coderbee.veganloversclub.networking.model.MealAreasResponse
import com.coderbee.veganloversclub.networking.model.MealCategoriesResponse
import com.coderbee.veganloversclub.networking.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealDBApi {
    @GET("search.php")
    suspend fun searchMeal(@Query("s") name: String): MealResponse

    @GET("lookup.php")
    suspend fun mealDetailsById(@Query("i") id: String): MealResponse

    @GET("categories.php")
    suspend fun mealCategories(): CategoryResponse

    @GET("list.php")
    suspend fun listAllCategories(@Query("c") key: String = "list"): MealCategoriesResponse

    @GET("list.php")
    suspend fun listAllAreas(@Query("a") key: String = "list"): MealAreasResponse
}
