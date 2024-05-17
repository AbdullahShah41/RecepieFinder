package com.example.recepiesapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.recepiesapplication.ui.screen.HomeScreen
import com.example.recepiesapplication.ui.theme.RecepiesApplicationTheme
import com.example.recepiesapplication.ui.viewmodel.RecipeViewModel

class DashboardActivity : ComponentActivity() {

    private val recipeViewModel: RecipeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        MaterialTheme.colorScheme.background
        setContent {
            RecepiesApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    HomeScreen(recipeViewModel = recipeViewModel)
                }
            }
        }
    }
}

