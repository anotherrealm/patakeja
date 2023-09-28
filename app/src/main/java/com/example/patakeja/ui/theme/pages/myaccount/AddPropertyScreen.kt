package com.example.patakeja.ui.theme.pages.myaccount

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.patakeja.R
import com.example.patakeja.models.PropertyListing
import com.example.patakeja.ui.theme.PataKejaTheme


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AddPropertyScreen(
    navController: NavController,
    propertyListings: MutableList<PropertyListing> = remember { mutableListOf() }

) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var propertyType by remember { mutableStateOf("") }
    var bedrooms by remember { mutableStateOf("") }
    var baths by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }

    LocalSoftwareKeyboardController.current
    LocalContext.current

    LocalUriHandler.current

    LocalDensity.current.density

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Add Property",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
            keyboardActions = KeyboardActions(
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = androidx.compose.ui.text.input.ImeAction.Default
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text(text = "Price") },
            keyboardActions = KeyboardActions(
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = androidx.compose.ui.text.input.ImeAction.Default,
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = propertyType,
            onValueChange = { propertyType = it },
            label = { Text(text = "Property Type") },
            keyboardActions = KeyboardActions(
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = androidx.compose.ui.text.input.ImeAction.Default
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = bedrooms,
            onValueChange = { bedrooms = it },
            label = { Text(text = "Bedrooms") },
            keyboardActions = KeyboardActions(
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = androidx.compose.ui.text.input.ImeAction.Default,
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = baths,
            onValueChange = { baths = it },
            label = { Text(text = "Baths") },
            keyboardActions = KeyboardActions(
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = androidx.compose.ui.text.input.ImeAction.Default,
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text(text = "Location") },
            keyboardActions = KeyboardActions(
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = androidx.compose.ui.text.input.ImeAction.Default
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = details,
            onValueChange = { details = it },
            label = { Text(text = "Details") },
            keyboardActions = KeyboardActions(
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = androidx.compose.ui.text.input.ImeAction.Default
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Create a new property listing and add it to the list
                propertyListings.add(
                    PropertyListing(
                        id = propertyListings.size + 1, // Generate a unique ID
                        name = name,
                        price = price.toIntOrNull() ?: 0,
                        propertyType = propertyType,
                        bedrooms = bedrooms.toIntOrNull() ?: 0,
                        baths = baths.toIntOrNull() ?: 0,
                        location = location,
                        details = details,
                        agentName = "Agent Name",
                        agentPhoneNumber = "Agent Phone",
                        agentEmail = "Agent Email",
                        callIcon = 0, // Replace with actual icons
                        emailIcon = 0, // Replace with actual icons
                        isSaved = false,
                        bedIconResId = R.drawable.bed,
                        bathIconResId = R.drawable.bath,
                        locationIconResId = R.drawable.iclocation,
                        images = listOf()
                    )
                )

                // Navigate back to the home screen
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Add Property")
        }
    }
}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AddPropertyScreenPreview() {
    PataKejaTheme {
        AddPropertyScreen(rememberNavController())
    }
}
