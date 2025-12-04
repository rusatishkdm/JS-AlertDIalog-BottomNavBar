package com.example.jc_ui_components_bottom_nav_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search

/**
 *
 * Created by satish on 04,December,2025
 * MyHealthCare, Bengaluru
 */
object Constants {

    val bottomNavItems = listOf(
        // Home
        BottomNavItem(
            label = "Home",
            route = "home",
            icon = Icons.Outlined.Home,
            badgeCount = 2
        ),

        BottomNavItem(
            label = "Search",
            route = "search",
            icon = Icons.Outlined.Search,
            badgeCount = null
        ),

        BottomNavItem(
            label = "Profile",
            route = "profile",
            icon = Icons.Outlined.Person,
            badgeCount = null
        )
    )
}