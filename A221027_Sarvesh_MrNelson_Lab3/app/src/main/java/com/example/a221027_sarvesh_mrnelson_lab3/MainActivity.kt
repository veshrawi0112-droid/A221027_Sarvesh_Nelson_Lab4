package com.example.a221027_sarvesh_mrnelson_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.example.a221027_sarvesh_mrnelson_lab3.ui.theme.Lab3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab3Theme {
                Scaffold(
                    bottomBar = { SimpleBottomNav() }
                ) { padding ->
                    SimpleScreen(Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun SimpleScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        // Search Bar
        Box(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
                    .padding(12.dp)
            ) {
                Icon(Icons.Default.Search, contentDescription = "Search")
                Text(" Search stores and food", color = Color.Gray)
            }
        }

        Column(Modifier.padding(16.dp)) {

            // Categories
            Text(
                "Categories",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CatIcon("Surprises", Icons.Default.ShoppingCart)
                CatIcon("Dine-In", Icons.Default.Place)
                CatIcon("Meals", Icons.Default.Star)
                CatIcon("Pastries", Icons.Default.Info)
            }

            // Expandable Card Section
            Text(
                "Near to you →",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
            )

            ExpandableCard()
        }

        // Map Banner
        Row(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.LocationOn, contentDescription = "Map", tint = Color.White)
                Text(
                    "  See what's nearby\n  on the map",
                    color = Color.White
                )
            }

            Box(
                Modifier
                    .background(
                        MaterialTheme.colorScheme.secondary,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text("Open Map", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun ExpandableCard() {
    var expanded by remember { mutableStateOf(false) }

    Card(
        onClick = { expanded = !expanded },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        Column(Modifier.padding(16.dp)) {

            Text("Weekday Lunch Special", fontWeight = FontWeight.Bold)

            Row {
                Text("RM 45.00 ", fontWeight = FontWeight.Bold)
                Text("50% off", color = MaterialTheme.colorScheme.primary)
            }

            if (expanded) {
                Text(
                    "Grand Hotel Buffet\n20:00 - 22:30\n12.5 km away",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun CatIcon(label: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            Modifier
                .size(60.dp)
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = label)
        }

        Text(label, fontSize = 12.sp)
    }
}

@Composable
fun SimpleBottomNav() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BottomIcon("HOME", Icons.Default.Home, true)
        BottomIcon("PARCELS", Icons.Default.Build, false)
        BottomIcon("CART", Icons.Default.ShoppingCart, false)
        BottomIcon("ORDERS", Icons.Default.Info, false)
        BottomIcon("ACCOUNT", Icons.Default.Person, false)
    }
}

@Composable
fun BottomIcon(label: String, icon: ImageVector, selected: Boolean) {
    val color = if (selected) MaterialTheme.colorScheme.primary else Color.Gray

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = label, tint = color)
        Text(label, fontSize = 10.sp, color = color)
    }
}