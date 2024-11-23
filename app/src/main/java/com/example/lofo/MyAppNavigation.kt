package com.example.lofo

import android.app.Application
import androidx .compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.lofo.db.Database
import com.example.lofo.pages.FoundItemInputScreen
import com.example.lofo.pages.Home
import com.example.lofo.pages.Login
import com.example.lofo.pages.LostItemInputScreen
import com.example.lofo.pages.Main
import com.example.lofo.pages.Signup
import com.example.lofo.viewmodel.FoundItemViewModel
import com.example.lofo.viewmodel.LostItemViewModel


@Composable
fun MyAppNavigation (modifier: Modifier=Modifier, authViewModel: AuthViewModel){
    val navController=rememberNavController()
    val LviewModel: LostItemViewModel = viewModel()
    val FviewModel: FoundItemViewModel = viewModel()

    NavHost(navController=navController,startDestination="login",builder={
        composable("login"){
            Login(modifier,navController,authViewModel)
        }
        composable("signup") {
            Signup(modifier,navController,authViewModel )
        }
        composable("Home") {
            Home(modifier,navController,authViewModel,LviewModel,FviewModel)
        }
        composable("Main_screen") {
            Main(navController,LviewModel,FviewModel)
        }
        composable("lost_Screen") {
            LostItemInputScreen(LviewModel,navController)
        }
        composable("found_screen") {
            FoundItemInputScreen(FviewModel,navController)
        }
    })
}