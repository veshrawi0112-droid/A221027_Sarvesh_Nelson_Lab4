package com.example.a221027_sarvesh_mrnelson_lab4

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var foodData = FoodData()

    fun updateFood(foodName: String, quantity: String, location: String) {
        foodData = FoodData(foodName, quantity, location)
    }
}