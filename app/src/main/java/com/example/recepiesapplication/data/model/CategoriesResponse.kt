package com.example.recepiesapplication.data.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponse(
    @SerializedName("categories")
    val categories: List<Category>
)