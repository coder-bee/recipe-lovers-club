package com.coderbee.veganloversclub.networking.datasource

import com.coderbee.veganloversclub.networking.model.CategoryResponse
import com.coderbee.veganloversclub.networking.model.MealAreasResponse
import com.coderbee.veganloversclub.networking.model.MealCategoriesResponse
import com.coderbee.veganloversclub.networking.model.MealResponse

interface MealDBApiDataSource {
    suspend fun searchMeals(criteria: String): Result<MealResponse>
    suspend fun mealDetails(mealId: String): Result<MealResponse>
    suspend fun mealCategories(): Result<CategoryResponse>
    suspend fun getListOfMealCategories(): Result<MealCategoriesResponse>
    suspend fun getListOfMealAreas(): Result<MealAreasResponse>
}

class MealDBDataSource(
    private val api: MealDBApi = MealDBApiFactory.create(baseURL)
) : MealDBApiDataSource {

    override suspend fun searchMeals(criteria: String): Result<MealResponse> = try {
        val data = api.searchMeal(criteria)
        Result.success(data)
    } catch (error: Throwable) {
        Result.failure(error)
    }

    override suspend fun mealDetails(mealId: String): Result<MealResponse> = try {
        val data = api.mealDetailsById(mealId)
        Result.success(data)
    } catch (error: Throwable) {
        Result.failure(error)
    }

    override suspend fun mealCategories(): Result<CategoryResponse> = try {
        val data = api.mealCategories()
        Result.success(data)
    } catch (error: Throwable) {
        Result.failure(error)
    }

    override suspend fun getListOfMealCategories(): Result<MealCategoriesResponse> = try {
        val data = api.listAllCategories()
        Result.success(data)
    } catch (error: Throwable) {
        Result.failure(error)
    }

    override suspend fun getListOfMealAreas(): Result<MealAreasResponse> = try {
        val data = api.listAllAreas()
        Result.success(data)
    } catch (error: Throwable) {
        Result.failure(error)
    }

    companion object {
        private const val baseURL = "https://www.themealdb.com/api/json/v1/1/"
    }
}