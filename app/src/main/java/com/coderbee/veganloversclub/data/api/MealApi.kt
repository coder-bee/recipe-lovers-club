package com.coderbee.veganloversclub.data.api

import com.coderbee.veganloversclub.data.api.model.Meal
import retrofit2.http.GET

interface MealApi {

    @GET(ApiConstants.END_POINTS)
    suspend fun getMeal():List<Meal>
}