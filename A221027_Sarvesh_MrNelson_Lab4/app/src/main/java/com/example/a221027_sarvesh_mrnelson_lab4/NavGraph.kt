package com.example.a221027_sarvesh_mrnelson_lab4

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val viewModel: MainViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "form"
    ) {

        composable("form") {
            FoodFormScreen(navController, viewModel)
        }

        composable("preview") {
            FoodPreviewScreen(navController, viewModel)
        }

        composable("details") {
            FoodDetailsScreen(navController, viewModel)
        }
    }
}