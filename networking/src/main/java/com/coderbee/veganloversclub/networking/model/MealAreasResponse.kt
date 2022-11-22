package com.coderbee.veganloversclub.networking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealAreasResponse(
    val meals: List<AreaId>
)

@Serializable
data class AreaId(
    @SerialName("strArea")
    val area: String
)

