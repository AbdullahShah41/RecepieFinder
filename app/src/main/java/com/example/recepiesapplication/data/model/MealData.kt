package com.example.recepiesapplication.data.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MealData(
    @SerializedName("meals")
    val meals: List<MealX>
)