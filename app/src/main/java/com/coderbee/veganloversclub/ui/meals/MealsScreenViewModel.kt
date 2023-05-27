package com.coderbee.veganloversclub.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderbee.veganloversclub.model.Mealsrepo
import com.coderbee.veganloversclub.model.response.MealCategoriesResponse
import com.coderbee.veganloversclub.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsScreenViewModel (private val repository: Mealsrepo = Mealsrepo()): ViewModel(){

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meal = getMeals()
            mealState.value = meal
        }
    }
    val mealState = mutableStateOf(emptyList<MealResponse>())

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}