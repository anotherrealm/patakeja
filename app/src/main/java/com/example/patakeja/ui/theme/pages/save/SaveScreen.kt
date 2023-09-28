import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.patakeja.models.PropertyListing
import com.example.patakeja.ui.theme.pages.property.PropertyListingCard

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SaveScreen(savedProperties: List<PropertyListing>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Saved Properties") },
                backgroundColor = Color.White,
                elevation = 4.dp
            )
        }
    ) {
        if (savedProperties.isEmpty()) {
            // Display a message when there are no saved properties.
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .height(16.dp)
            )
            Text(
                text = "No saved properties yet.",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
        } else {
            // Display the list of saved properties.
            LazyColumn() {
                items(savedProperties) { property ->
                    // Display each saved property as a card or list item.
                    PropertyListingCard(
                        propertyListing = property,
                        onClick = {
                            // Handle click on a saved property.
                        },
                        onSaveClick = {
                            // Handle unsave action.
                        },
                        onCallClick = {
                            // Handle call action.
                        },
                        onEmailClick = {
                            // Handle email action.
                        }
                    )
                }
            }
        }
    }
}
