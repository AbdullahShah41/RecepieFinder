package com.example.recepiesapplication.ui.viewmodel

import com.example.recepiesapplication.data.model.Meal


sealed class RecipeViewState {
    object Loading: RecipeViewState()
    data class Success(val recipes: List<Meal>): RecipeViewState()
    data class Error(val message: String): RecipeViewState()



}
