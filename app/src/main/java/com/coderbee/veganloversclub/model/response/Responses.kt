package com.coderbee.veganloversclub.model.response

import com.google.gson.annotations.SerializedName

data class MealCategoriesResponse(val categories: List<MealResponse>)

data class MealResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageurl: String
)