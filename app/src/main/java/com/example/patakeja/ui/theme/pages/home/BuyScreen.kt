package com.example.patakeja.ui.theme.pages.home


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.patakeja.data.mockPropertyListings
import com.example.patakeja.ui.theme.PataKejaTheme
import com.example.patakeja.ui.theme.pages.property.PropertyListingScreen

@Composable
fun BuyScreen(navController: NavController) {
    PropertyListingScreen(
        propertyListings = mockPropertyListings,
        navController = navController
    )
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
    )
}
@Preview(showBackground = true)
@Composable
fun BuyScreenPreview() {
    PataKejaTheme {
        BuyScreen(rememberNavController())
    }
}
