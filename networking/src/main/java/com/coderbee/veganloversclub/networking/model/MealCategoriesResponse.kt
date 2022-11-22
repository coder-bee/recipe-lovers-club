package com.coderbee.veganloversclub.networking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealCategoriesResponse(
    val meals: List<CategoryId>
)

@Serializable
data class CategoryId(
    @SerialName("strCategory")
    val category: String
)
