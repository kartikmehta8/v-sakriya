package com.example.template.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.template.screens.StolenCarUpdatesScreen
import com.example.template.screens.components.bottomNav.BottomNavItem

@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
           StolenCarUpdatesScreen(paddingValues)
        }
        composable(BottomNavItem.CarHistory .screen_route) {
            StolenCarUpdatesScreen(paddingValues)
        }
        composable(BottomNavItem.Missing .screen_route) {
            StolenCarUpdatesScreen(paddingValues)
        }
        composable(BottomNavItem.Profile .screen_route) {
            StolenCarUpdatesScreen(paddingValues)
        }
        composable(BottomNavItem.TrackerCar .screen_route) {
            StolenCarUpdatesScreen(paddingValues)
        }
    }
}