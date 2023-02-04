package com.example.template.screens.components.bottomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CarCrash
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String, var icon:ImageVector, var screen_route:String){
    object CarHistory: BottomNavItem("CarHistory",  icon =  Icons.Filled.CarCrash,"CarHistory")
    object TrackerCar: BottomNavItem("My Network",Icons.Filled.TrackChanges,"TrackaCar",)
    object Home: BottomNavItem("home",Icons.Filled.Home,"home")
    object Missing: BottomNavItem("Notification",Icons.Filled.Book,"missingDiary")
    object Profile: BottomNavItem("Jobs",Icons.Filled.Person,"Profile")
}
