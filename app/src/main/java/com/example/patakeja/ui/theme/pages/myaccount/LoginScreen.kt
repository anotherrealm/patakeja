package com.example.patakeja.ui.theme.pages.myaccount

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.patakeja.data.AuthRepository
import com.example.patakeja.navigation.ROUTE_ADD_PROPERTY
import com.example.patakeja.navigation.ROUTE_HOME
import com.example.patakeja.ui.theme.PataKejaTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current
        Text(
            text ="Login",
            fontSize = 30.sp,
            color = Color.Blue,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            letterSpacing = 0.1.em
        )

        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text(text = "Email *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text(text = "Password *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                var authRepository = AuthRepository(navController, context)
                authRepository.login(email.text.trim(), password.text.trim())
                navController.navigate(ROUTE_ADD_PROPERTY)
                      },
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, color = Color.LightGray),
        ) {
            Text(
                text = "Log in",
                color = Color.Black
            )
        }
    }
}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LoginScreenPreview() {
    PataKejaTheme {
        LoginScreen(rememberNavController())
    }
}