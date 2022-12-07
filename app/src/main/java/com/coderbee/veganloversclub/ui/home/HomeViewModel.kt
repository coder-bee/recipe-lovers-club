package com.coderbee.veganloversclub.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderbee.veganloversclub.data.api.model.Meal
import com.coderbee.veganloversclub.data.repo.MealRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mealRepo: MealRepo
): ViewModel() {

    private val _state = MutableStateFlow(emptyList<Meal>())
    val state: StateFlow<List<Meal>>
    get() = _state

    init {
        viewModelScope.launch {
            val meals = mealRepo.getMeals()
            _state.value = meals
        }
    }

}