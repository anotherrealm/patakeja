package com.example.patakeja.ui.theme.pages.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.rememberNavController
import com.example.patakeja.ui.theme.PataKejaTheme
import com.example.patakeja.ui.theme.pages.myaccount.LoginScreen


@Composable
fun Dialogbox(
    isOpen: Boolean,
    onDismiss: () -> Unit,
    onSearch: (minPrice: Int, maxPrice: Int, propertyType: String) -> Unit
) {
    var minPrice by remember { mutableStateOf(0) }
    var maxPrice by remember { mutableStateOf(0) }
    var propertyType by remember { mutableStateOf("") }

    if (isOpen) {
        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TextField(
                        value = minPrice.toString(),
                        onValueChange = { minPrice = it.toIntOrNull() ?: 0 },
                        singleLine = true,
                        label = { Text("Minimum Price") },
                        colors = TextFieldDefaults.textFieldColors(placeholderColor = Color.Black)
                    )

                    TextField(
                        value = maxPrice.toString(),
                        onValueChange = { maxPrice = it.toIntOrNull() ?: 0 },
                        singleLine = true,
                        label = { Text("Maximum Price") },
                                colors = TextFieldDefaults.textFieldColors(placeholderColor = Color.Black)
                    )

                    TextField(
                        value = propertyType,
                        onValueChange = { propertyType = it },
                        singleLine = true,
                        label = { Text("Property Type") },
                        colors = TextFieldDefaults.textFieldColors(placeholderColor = Color.Black)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { onDismiss() }
                        ) {
                            Text("Cancel")
                        }

                        Button(
                            onClick = {
                                onSearch(minPrice, maxPrice, propertyType)
                                onDismiss()
                            }
                        ) {
                            Text("Search")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun DialogboxPreview() {
    PataKejaTheme {
        Dialogbox(
            isOpen = true,
            onDismiss = {},
            onSearch = { _, _, _ -> /* Handle search action here */ }
        )
    }
}
