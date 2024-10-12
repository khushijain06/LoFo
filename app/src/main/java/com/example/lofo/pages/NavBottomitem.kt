package com.example.lofo.pages

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import com.example.lofo.R

sealed class NavBottomitem(val route: String, val icon: Int, val title: String) {
    object Home : NavBottomitem("home", R.drawable.baseline_home_filled_24 , "Home")
    object Profile : NavBottomitem("profile", R.drawable.baseline_person_24, "Profile")
    object found : NavBottomitem("found item", R.drawable.lost, "Found")
    object lost: NavBottomitem("lost item", R.drawable.lost,"lost")
}
