package com.example.recepiesapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.recepiesapplication.ui.screen.HomeScreen
import com.example.recepiesapplication.ui.theme.RecepiesApplicationTheme
import com.example.recepiesapplication.ui.viewmodel.RecipeViewModel

class DashboardActivity : ComponentActivity() {

    private lateinit var activity: DashboardActivity

    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        activity = this;

//        MaterialTheme.colorScheme.background
        setContent {
            RecepiesApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = Color.White
                ) {
                    HomeScreen(state = recipeViewModel.state.value, activity)
                }
            }
        }
    }
}

