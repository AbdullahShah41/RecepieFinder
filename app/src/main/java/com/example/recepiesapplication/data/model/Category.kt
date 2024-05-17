package com.example.recepiesapplication.data.model

// Use serializable for data class
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)