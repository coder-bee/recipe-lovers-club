package com.coderbee.veganloversclub.model

import com.coderbee.veganloversclub.model.response.MealCategoriesResponse
import com.coderbee.veganloversclub.model.api.MealsWebService

class Mealsrepo(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealCategoriesResponse{
        return webService.getMeals()
    }
}