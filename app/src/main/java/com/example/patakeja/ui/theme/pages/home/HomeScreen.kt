package com.example.patakeja.ui.theme.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.patakeja.R
import com.example.patakeja.data.mockPropertyListings
import com.example.patakeja.navigation.ROUTE_HOME
import com.example.patakeja.navigation.ROUTE_MY_ACCOUNT
import com.example.patakeja.navigation.ROUTE_SAVE
import com.example.patakeja.ui.theme.PataKejaTheme
import com.example.patakeja.ui.theme.pages.property.PropertyListingScreen


enum class Tab {
    SEARCH,
    SAVE,
    ACCOUNT
}

@Composable
fun HomeScreen(navController: NavHostController) {
    var isDialogOpen by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableStateOf(Tab.SEARCH) }
    var minPrice by remember { mutableStateOf(0) }
    var maxPrice by remember { mutableStateOf(0) }
    var propertyType by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        item {
            Spacer(modifier = Modifier.height(26.dp))

            // Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Button(
                        onClick = { isDialogOpen = true },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = "Rent")
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Button(
                        onClick = { isDialogOpen = true },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = "Buy")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Property Listings
            PropertyListingScreen(
                propertyListings = mockPropertyListings,
                navController = navController
            )
        }

        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)

            )
        }
    }

    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {

        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            },
            label = { Text(text = "search") },
            selected = selectedTab == Tab.SEARCH,
            onClick = {
                selectedTab = Tab.SEARCH
                navController.navigate(ROUTE_HOME)
            }
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.save),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            },
            label = { Text(text = "Save") },
            selected = selectedTab == Tab.SAVE,
            onClick = {
                selectedTab = Tab.SAVE
                navController.navigate(ROUTE_SAVE)
            }
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.account),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            },
            label = { Text(text = "Account") },
            selected = selectedTab == Tab.ACCOUNT,
            onClick = {
                selectedTab = Tab.ACCOUNT
                navController.navigate(ROUTE_MY_ACCOUNT)
            }
        )
    }


    // Dialog Box
    Dialogbox(
        isOpen = isDialogOpen,
        onDismiss = { isDialogOpen = false },
        onSearch = { min, max, type ->
            minPrice = min
            maxPrice = max
            propertyType = type
        }
    )
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PataKejaTheme {
        HomeScreen(rememberNavController())
    }
}