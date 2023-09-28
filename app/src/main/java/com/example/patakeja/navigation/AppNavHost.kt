package com.example.patakeja.navigation

import SaveScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.patakeja.models.PropertyListing
import com.example.patakeja.ui.theme.pages.home.BuyScreen
import com.example.patakeja.ui.theme.pages.home.HomeScreen
import com.example.patakeja.ui.theme.pages.home.RentScreen
import com.example.patakeja.ui.theme.pages.myaccount.AddPropertyScreen
import com.example.patakeja.ui.theme.pages.myaccount.LoginScreen
import com.example.patakeja.ui.theme.pages.myaccount.SignUpScreen
import com.example.patakeja.ui.theme.pages.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    propertyListings: MutableList<PropertyListing> = remember { mutableListOf() },
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ROUTE_SPLASHSCREEN
    ) {
        composable(ROUTE_SPLASHSCREEN) {
            SplashScreen(navController)
        }
        composable(route = BottomBar.Home.route)
        {
            HomeScreen(navController)
        }
        composable(route = BottomBar.Save.route)
        {
            SaveScreen(navController)
        }
        composable(route = BottomBar.Account.route)
        {
            SignUpScreen(navController)
        }

        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_RENT) {
            RentScreen(navController)
        }
        composable(ROUTE_BUY) {
            BuyScreen(navController)
        }
        composable(ROUTE_SAVE) {
            SaveScreen(navController)
        }
        composable(ROUTE_MY_ACCOUNT) {
            SignUpScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_ADD_PROPERTY){
            AddPropertyScreen(navController, propertyListings)
        }
    }
}

