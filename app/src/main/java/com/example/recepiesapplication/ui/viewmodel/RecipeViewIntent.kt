package com.example.recepiesapplication.ui.viewmodel

sealed class RecipeViewIntent {
    object LoadRandomRecipe : RecipeViewIntent()
    data class SearchRecipes(val query: String) : RecipeViewIntent()
}



