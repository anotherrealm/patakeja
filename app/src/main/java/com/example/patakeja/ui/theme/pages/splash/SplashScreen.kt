package com.example.patakeja.ui.theme.pages.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.patakeja.navigation.ROUTE_HOME
import com.example.patakeja.ui.theme.PataKejaTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavHostController) {
    val scope = rememberCoroutineScope()

    // Launch a coroutine to delay navigation
    LaunchedEffect(Unit) {
        scope.launch {
            delay(1500L) // Delay for 1.5 seconds
            navController.navigate(ROUTE_HOME)
        }
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(90.dp) // Adjust the size as per your preference
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = "PataKeja",
            color = Color.Black,
            fontSize = 44.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun     SplashScreenPreview() {
    PataKejaTheme {
        SplashScreen(rememberNavController())
    }
}