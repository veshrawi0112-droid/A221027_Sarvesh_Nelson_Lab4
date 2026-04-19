package com.example.a221027_sarvesh_mrnelson_lab4

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// ------------------ SCREEN 1 ------------------
@Composable
fun FoodFormScreen(navController: NavController, viewModel: MainViewModel) {

    var foodName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Food Donation Form", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = foodName, onValueChange = { foodName = it }, label = { Text("Food Name") })
        OutlinedTextField(value = quantity, onValueChange = { quantity = it }, label = { Text("Quantity") })
        OutlinedTextField(value = location, onValueChange = { location = it }, label = { Text("Location") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.updateFood(foodName, quantity, location)
            navController.navigate("preview")
        }) {
            Text("Preview Food")
        }
    }
}

// ------------------ SCREEN 2 ------------------
@Composable
fun FoodPreviewScreen(navController: NavController, viewModel: MainViewModel) {

    val data = viewModel.foodData

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Food Preview", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text("🍱 Food: ${data.foodName}")
        Text("📦 Quantity: ${data.quantity}")
        Text("📍 Location: ${data.location}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("details")
        }) {
            Text("Confirm Donation")
        }
    }
}

// ------------------ SCREEN 3 ------------------
@Composable
fun FoodDetailsScreen(navController: NavController, viewModel: MainViewModel) {

    val data = viewModel.foodData

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Donation Successful", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text("🎉 Your food has been listed!")
        Text("Food: ${data.foodName}")
        Text("Quantity: ${data.quantity}")
        Text("Pickup at: ${data.location}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("form")
        }) {
            Text("Add Another Food")
        }
    }
}