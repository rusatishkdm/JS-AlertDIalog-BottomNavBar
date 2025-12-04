package com.example.jc_ui_components_bottom_nav_bar

import androidx.compose.ui.graphics.vector.ImageVector

/**
 *
 * Created by satish on 04,December,2025
 */
data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int? = null
)