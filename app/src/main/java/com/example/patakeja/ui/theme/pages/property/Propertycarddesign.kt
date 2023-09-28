package com.example.patakeja.ui.theme.pages.property

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
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
fun PropertyListingCard(
    propertyListing: PropertyListing,
    onClick: () -> Unit,
    onSaveClick: () -> Unit,
    onCallClick: () -> Unit,
    onEmailClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            // Save Icon
            Icon(
                painter = painterResource(
                    id = if (propertyListing.isSaved) R.drawable.saved else R.drawable.save
                ),
                contentDescription = if (propertyListing.isSaved) "Saved" else "Save",
                tint = if (propertyListing.isSaved) Color.Red else Color.Gray,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        propertyListing.isSaved = !propertyListing.isSaved // Toggle the save state
                        onSaveClick()
                    }
            )

            // Property Images
            Image(
                painter = painterResource(id = propertyListing.images.first()),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
            )

            // Property Details
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = propertyListing.propertyType,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(4.dp))

                // Bed Icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bed),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "${propertyListing.bedrooms} ",
                        style = MaterialTheme.typography.subtitle1,
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bath),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = " ${propertyListing.baths}",
                        style = MaterialTheme.typography.subtitle1,
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Location Icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.iclocation),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Location: ${propertyListing.location}",
                        style = MaterialTheme.typography.subtitle1,
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = "Price: $${propertyListing.price}",
                        style = MaterialTheme.typography.subtitle1,
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Buttons (e.g., Call Agent, Email Agent)
                // Agent Details
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.call),
                        contentDescription = "Call Agent",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                onCallClick()
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.mail),
                        contentDescription = "Email Agent",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                onEmailClick()
                            }
                    )
                    Text(
                        text = propertyListing.agentName,
                        style = MaterialTheme.typography.body2,
                        color = Color.Black,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PropertyListingCardPreview() {
    PataKejaTheme {
        PropertyListingCard(
            propertyListing = mockPropertyListings.first(),
            onClick = {},
            onSaveClick = {},
            onCallClick = {},
            onEmailClick = {}
        )
    }
}




