package com.example.patakeja.ui.theme.pages.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.patakeja.data.mockPropertyListings
import com.example.patakeja.ui.theme.pages.property.PropertyListingScreen

@Composable
fun RentScreen(navController: NavController) {
    PropertyListingScreen(
        propertyListings = mockPropertyListings,
        navController = navController
    )
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
    )
}