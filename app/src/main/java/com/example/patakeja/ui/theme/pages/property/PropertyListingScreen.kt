package com.example.patakeja.ui.theme.pages.property

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.patakeja.data.mockPropertyListings
import com.example.patakeja.models.PropertyListing
import com.example.patakeja.navigation.ROUTE_PROPERTY_DETAILS
import com.example.patakeja.ui.theme.PataKejaTheme

@Composable
fun PropertyListingScreen(
    propertyListings: List<PropertyListing>,
    navController: NavController
) {
    Column {
        for (propertyListing in propertyListings) {
            PropertyListingCard(
                propertyListing = propertyListing,
                onClick = {
                    navController.navigate(ROUTE_PROPERTY_DETAILS)
                },
                onSaveClick = {},
                onCallClick = {
                    // Handle calling the agent here
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${propertyListing.agentPhoneNumber}"))
                    // Check for permissions and start the call intent
                },
                onEmailClick = {

                    val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", propertyListing.agentEmail, null))

                }
            )
            }
    }
}

@Preview(showBackground = true)
@Composable
fun PropertyListScreenPreview() {
    PataKejaTheme {
        PropertyListingScreen(propertyListings = mockPropertyListings, navController = rememberNavController())
    }
}
