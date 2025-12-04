package com.example.jc_ui_components_bottom_nav_bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jc_ui_components_bottom_nav_bar.ui.components.HomeScreen
import com.example.jc_ui_components_bottom_nav_bar.ui.components.ProfileScreen
import com.example.jc_ui_components_bottom_nav_bar.ui.components.SearchScreen
import com.example.jc_ui_components_bottom_nav_bar.ui.theme.JCAlertDialogBottomNavBarTheme
import com.example.jc_ui_components_bottom_nav_bar.ui.theme.Teal10
import com.example.jc_ui_components_bottom_nav_bar.ui.theme.Teal40
import com.example.jc_ui_components_bottom_nav_bar.ui.theme.Teal60
import com.example.jc_ui_components_bottom_nav_bar.ui.theme.Teal80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JCAlertDialogBottomNavBarTheme(darkTheme = false, dynamicColor = true) {
                val navController = rememberNavController()
                Surface(color = Color.White) {
                    Scaffold(
                        bottomBar = { BottomNavigationBar(navController = navController) },
                    ) { innerPadding ->
                        NavHostContainer(navController, paddingValues = innerPadding)
                    }
                }
            }
        }
    }
}

@Composable
fun NavHostContainer(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        startDestination = "home",
        builder = {
            composable("home") {
                HomeScreen()
            }
            composable("search") {
                SearchScreen()
            }
            composable("profile") {
                ProfileScreen()
            }
        }
    )
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(containerColor = Teal60) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val currentRoute = navBackStackEntry?.destination?.route

        Constants.bottomNavItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route)
                },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },
                label = {
                    Text(
                        text = navItem.label,
                        fontWeight = if (currentRoute == navItem.route) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 14.sp
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = Teal10
                )
            )
        }
    }
}
