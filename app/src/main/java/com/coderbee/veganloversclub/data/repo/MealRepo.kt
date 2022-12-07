package com.coderbee.veganloversclub.data.repo

import com.coderbee.veganloversclub.data.api.MealApi
import com.coderbee.veganloversclub.data.api.model.Meal
import javax.inject.Inject

class MealRepo @Inject constructor(
    private val mealApi: MealApi
) {
    suspend fun getMeals(): List<Meal> {
        return mealApi.getMeal()
    }
}