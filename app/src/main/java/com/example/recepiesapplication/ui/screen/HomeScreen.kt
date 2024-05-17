package com.example.recepiesapplication.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.recepiesapplication.ui.viewmodel.RecipeViewIntent
import com.example.recepiesapplication.ui.viewmodel.RecipeViewModel
import com.example.recepiesapplication.ui.viewmodel.RecipeViewState
import com.yourssohail.recipefinderapp.ui.components.ErrorComponent
import com.yourssohail.recipefinderapp.ui.components.LoadingComponent
import com.yourssohail.recipefinderapp.ui.components.SuccessComponent

@Composable
fun HomeScreen(
    state: RecipeViewState = RecipeViewState.Loading,
    kFunction1: (RecipeViewModel.VMEvents) -> Unit
) {
//    val state by recipeViewModel.state

//    val viewModel = ViewModelProvider(activity).get(RecipeViewModel::class.java)

    when(state){
        // Loading component
        is RecipeViewState.Loading -> LoadingComponent()
        // Success Component
        is RecipeViewState.Success -> {
            val recepies = state.recipes
            SuccessComponent(recipes = recepies, onSearchClicked = { query ->
                kFunction1.invoke(RecipeViewModel.VMEvents.TestEvent)
//                viewModel.processIntent(RecipeViewIntent.SearchRecipes(query))
            })
        }
        // Failure Component
        is RecipeViewState.Error -> {
            val message = state.message
            ErrorComponent(message = message, onRefreshClicked = {
                viewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
            })
        }
    }

    LaunchedEffect(Unit) {
        viewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
    }

}