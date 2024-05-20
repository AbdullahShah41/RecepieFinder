package com.example.recepiesapplication.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.recepiesapplication.ui.viewmodel.RecipeViewIntent
import com.example.recepiesapplication.ui.viewmodel.RecipeViewModel
import com.example.recepiesapplication.ui.viewmodel.RecipeViewState
import com.yourssohail.recipefinderapp.ui.components.ErrorComponent
import com.yourssohail.recipefinderapp.ui.components.LoadingComponent
import com.yourssohail.recipefinderapp.ui.components.SuccessComponent

@Preview()
@Composable
fun HomeScreen(
    state: RecipeViewState = RecipeViewState.Loading,
    vmFunctionEvent: (RecipeViewModel.VMEvents) -> Unit
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
                vmFunctionEvent.invoke(RecipeViewModel.VMEvents.TestEvent)
                vmFunctionEvent.invoke(RecipeViewModel.VMEvents.searchRecipe(query))
//                viewModel.processIntent(RecipeViewIntent.SearchRecipes(query))
            })
        }
        // Failure Component
        is RecipeViewState.Error -> {
            val message = state.message
            ErrorComponent(message = message, onRefreshClicked = {
                vmFunctionEvent.invoke(RecipeViewModel.VMEvents.loadRandom)
//                viewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
            })
        }
    }

    LaunchedEffect(Unit) {
        vmFunctionEvent.invoke(RecipeViewModel.VMEvents.loadRandom)
//        viewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
    }

}