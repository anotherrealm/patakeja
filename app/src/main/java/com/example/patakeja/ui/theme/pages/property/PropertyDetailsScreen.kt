package com.example.patakeja.ui.theme.pages.property

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patakeja.R
import com.example.patakeja.data.mockPropertyListings
import com.example.patakeja.models.PropertyListing
import com.example.patakeja.ui.theme.PataKejaTheme

@Composable
fun PropertyDetailsScreen(propertyListing: PropertyListing, onBack: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Property Images
        propertyListing.images.forEach { _ ->
            Image(
                painter = painterResource(id = propertyListing.images.first()),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Property Details
        Text(
            text = "Property Type: ${propertyListing.propertyType}",
            style = MaterialTheme.typography.h6,
            color = Color.Black,
        )

        Text(
            text = "Price: $${propertyListing.price}",
            style = MaterialTheme.typography.body1,
            color = Color.Black,
        )

        Text(
            text = "Bedrooms: ${propertyListing.bedrooms}",
            style = MaterialTheme.typography.body1,
            color = Color.Black,
        )

        // Add more property details as needed...

        Spacer(modifier = Modifier.height(16.dp))

        // Property Icons (e.g., bedroom, location, phone, email)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bed),
                contentDescription = null,
                tint =  Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "${propertyListing.bedrooms} Bedrooms",
                style = MaterialTheme.typography.body2,
                color = Color.Black,
            )

            Icon(
                painter = painterResource(id = R.drawable.iclocation),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = propertyListing.location,
                style = MaterialTheme.typography.body2,
                color = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))



Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bed),
                contentDescription = "Bedrooms",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "${propertyListing.bedrooms} Bedrooms",
                style = MaterialTheme.typography.body2,
                color = Color.Black,
            )

            Icon(
                painter = painterResource(id = R.drawable.iclocation),
                contentDescription = "Location",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = propertyListing.location,
                style = MaterialTheme.typography.body2,
                color = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons (e.g., Call Agent, Email Agent)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.call),
                contentDescription = "Call Agent",
                modifier = Modifier.size(24.dp),
            )
            Image(
                painter = painterResource(id = R.drawable.mail),
                contentDescription = "Email Agent",
                modifier = Modifier.size(24.dp),
            )
            Text(
                text = propertyListing.agentName,
                style = MaterialTheme.typography.body2,
                color = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


// Back Button
Button(
onClick = { onBack() }
) {
    Text("Back")
}
}
}


@Preview(showBackground = true)
@Composable
fun PropertyDetailsPreview() {
    PataKejaTheme {
        PropertyDetailsScreen(
            propertyListing = mockPropertyListings.first(),
            onBack = {  }
        )
    }
}

