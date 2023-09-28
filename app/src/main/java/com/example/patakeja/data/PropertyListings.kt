package com.example.patakeja.data

import com.example.patakeja.R
import com.example.patakeja.models.PropertyListing

val mockPropertyListings = listOf(
    PropertyListing(
        id = 1,
        name = "Luxury Mansion",
        price = 2000000,
        propertyType = "Mansion",
        bedrooms = 5,
        baths = 2,
        location = "123 Main St",
        bedIconResId = R.drawable.bed,
        bathIconResId = R.drawable.bath,
        locationIconResId = R.drawable.iclocation,
        images = listOf(R.drawable.mansion, R.drawable.livingroom, R.drawable.bedrrr),
        agentName = "Morio",
        agentPhoneNumber = "+1234567890",
        agentEmail = "morio.des@gmail.com",
        callIcon = R.drawable.call,
        emailIcon = R.drawable.mail,
        details = "Spacious mansion with a beautiful view."
    ),
    PropertyListing(
        id = 2,
        name = "Cozy Apartment",
        price = 500000,
        propertyType = "Apartment",
        bedrooms = 2,
        baths = 2,
        location = "123 Main St",
        bedIconResId = R.drawable.bed,
        bathIconResId = R.drawable.bath,
        locationIconResId = R.drawable.iclocation,
        images = listOf(R.drawable.apartment, R.drawable.sitting, R.drawable.interior),
        agentName = "Lisa",
        agentPhoneNumber = "+1234567890",
        agentEmail = "lisa.gee@gmail.com",
        callIcon = R.drawable.call,
        emailIcon = R.drawable.mail,
        details = "Modern apartment in the city center."
    ),
    PropertyListing(
        id = 3,
        name = "Spacious Bungalow",
        price = 1500000,
        propertyType = "Bungalow",
        bedrooms = 3,
        baths = 2,
        location = "123 Main St",
        bedIconResId = R.drawable.bed,
        bathIconResId = R.drawable.bath,
        locationIconResId = R.drawable.iclocation,
        images = listOf(R.drawable.bungalow, R.drawable.room, R.drawable.interiors),
        agentName = "Jet lee",
        agentPhoneNumber = "+1234567890",
        agentEmail = "set.lee@gmail.com",
        callIcon = R.drawable.call,
        emailIcon = R.drawable.mail,
        details = "Charming bungalow with a garden."
    )
)
