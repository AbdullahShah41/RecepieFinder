package com.example.recepiesapplication.data.api

import com.example.recepiesapplication.data.model.Category
import com.example.recepiesapplication.data.model.Meal
import com.example.recepiesapplication.data.model.MealResponse
import com.example.recepiesapplication.utils.Common
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

object MealApiClient {

    private val apiClient = HttpClient(CIO){
        install(ContentNegotiation) {
            json()
        }
    }

    // For getting random recipe
    suspend fun getRandomRecipe(): List<Meal> {
        val url = Common.PATHS.PATH_URL
        val response = apiClient.get(url).body() as MealResponse
        return response.meals
    }

    // For getting searched recipes
    suspend fun getSearchedRecipe(query: String): List<Meal> {
        val url = Common.PATHS.PATH_URL_SEARCH + query
        val response = apiClient.get(url).body() as MealResponse
        return response.meals
    }

    // For displaying recipes categories
/*    suspend fun getRecipesCategories() : List<Category> {

    }*/

}