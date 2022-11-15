package com.coderbee.veganloversclub.networking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val categories: List<Category>
)

@Serializable
data class Category(
    @SerialName("idCategory")
    val id: String,
    @SerialName("strCategory")
    val category: String,
    @SerialName("strCategoryThumb")
    val thumbnailUrl: String,
    @SerialName("strCategoryDescription")
    val description: String,
)
