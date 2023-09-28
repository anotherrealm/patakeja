package com.example.patakeja.models

data class PropertyListing(
    val id: Int,
    val name: String,
    val price: Int,
    val propertyType: String,
    val bedrooms: Int,
    val baths: Int,
    val location: String,
    val bedIconResId: Int, // Resource ID for the bed icon
    val bathIconResId: Int, // Resource ID for the bath icon
    val locationIconResId: Int, // Resource ID for the location icon
    val images: List<Int>,
    val details: String,
    val agentName: String,
    val agentPhoneNumber: String,
    val agentEmail: String,
    val callIcon: Int,
    val emailIcon: Int,
    var isSaved: Boolean = false
)

