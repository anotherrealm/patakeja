package com.example.patakeja.navigation

import com.example.patakeja.R

sealed class BottomBar(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {



    // for Home
    object Home: BottomBar(
        route = "home",
        title = "Home",
        icon = R.drawable.search,
        icon_focused = R.drawable.search
    )

    // for Donor
    object Save: BottomBar(
        route = "save",
        title = "save",
        icon = R.drawable.save,
        icon_focused = R.drawable.save
    )
    // for receiver
    object Account: BottomBar(
        route = "my account",
        title = "my account",
        icon = R.drawable.account,
        icon_focused = R.drawable.account
    )


}

