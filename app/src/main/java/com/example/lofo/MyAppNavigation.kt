package com.example.lofo

import androidx .compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lofo.pages.Home
import com.example.lofo.pages.Login
import com.example.lofo.pages.Signup


@Composable
fun MyAppNavigation (modifier: Modifier=Modifier, authViewModel: AuthViewModel){
    val navController=rememberNavController()
    NavHost(navController=navController,startDestination="login",builder={
        composable("login"){
            Login(modifier,navController,authViewModel)
        }
        composable("signup") {
            Signup(modifier,navController,authViewModel )
        }
        composable("Home") {
            Home(modifier,navController,authViewModel)
        }
    })
}