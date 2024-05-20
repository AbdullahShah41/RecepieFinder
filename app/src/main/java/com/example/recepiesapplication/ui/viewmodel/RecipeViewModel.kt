package com.example.recepiesapplication.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recepiesapplication.data.api.MealApiClient
import io.ktor.events.Events
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {
    // Initial State is loading
    private val _state = mutableStateOf<RecipeViewState>(RecipeViewState.Loading)
    // Holding the state
    val state: State<RecipeViewState> = _state

/*
    fun processIntent(intent: RecipeViewIntent) {
        when(intent) {
            is RecipeViewIntent.LoadRandomRecipe -> loadRandomRecipe()
            is RecipeViewIntent.SearchRecipes -> searchRecipe(intent.query)

        }
    }

*/

    fun onEvent(events: VMEvents){

        when(events){
            VMEvents.TestEvent -> { // This is for testing
                 }
            VMEvents.loadRandom -> loadRandomRecipe()
            is VMEvents.searchRecipe -> searchRecipe(query = events.searchQuery)
        }

    }
    private fun loadRandomRecipe() {
        viewModelScope.launch {
            _state.value = RecipeViewState.Loading
            try {
                _state.value = RecipeViewState.Success(
                    MealApiClient.getRandomRecipe()
                )
            } catch(exception: Exception) {
                _state.value = RecipeViewState.Error("Error fetching recipe")
                Log.i("error", "Error while loading recipes : ${exception.localizedMessage} caused by : ${exception.cause}")
            }
        }
    }

    private fun searchRecipe(query: String) {
        viewModelScope.launch {
            _state.value = RecipeViewState.Loading
            try {
                _state.value = RecipeViewState.Success(
                    MealApiClient.getSearchedRecipe(query)
                )
            } catch (e: Exception) {
                _state.value = RecipeViewState.Error("Error fetching recipes")
            }
        }
    }

    sealed class VMEvents(){
        object TestEvent : VMEvents()
        // loading random
        object loadRandom : VMEvents()
        // search recipes
        data class searchRecipe(val searchQuery: String): VMEvents()

    }

}