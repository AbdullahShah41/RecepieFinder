package com.example.recepiesapplication.utils

interface Common {
    interface PATHS {
        companion object {
            // For getting random
            val PATH_URL = "https://www.themealdb.com/api/json/v1/1/random.php"
            // For getting search Recepies
            val PATH_URL_SEARCH = "https://www.themealdb.com/api/json/v1/1/search.php?s="
            // For getting recepies categories
            val PATH_URL_CATEGORIES = "www.themealdb.com/api/json/v1/1/categories.php"
        }
    }
}