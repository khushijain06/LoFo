package com.example.lofo.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lofo.NavItem
import com.example.lofo.ui.theme.black
import com.example.lofo.ui.theme.blue
import com.example.lofo.ui.theme.darkgrey
import com.example.lofo.ui.theme.red
import com.example.lofo.viewmodel.FoundItemViewModel
import com.example.lofo.viewmodel.LostItemViewModel

@Composable
fun Main(navHostController: NavHostController,LviewModel: LostItemViewModel, FviewModel: FoundItemViewModel) {
     Box(
       modifier = Modifier
           .fillMaxSize()
           .background(black),
       contentAlignment = Alignment.Center
     ) {
       Column( modifier = Modifier.align(alignment = Alignment.Center)) {
       ElevatedButton(onClick = { navHostController.navigate("lost_screen")},
          colors=ButtonDefaults.elevatedButtonColors(red), elevation = ButtonDefaults.elevatedButtonElevation(6.dp),
           ){
          Text(text = "LOST  SOMETHING?",
              Modifier.padding(7.dp),
                  fontSize = 17.sp,
              color = Color.White)
       }
         Spacer(modifier = Modifier.padding(10.dp))
           ElevatedButton(onClick = { navHostController.navigate("found_screen")},
               colors=ButtonDefaults.elevatedButtonColors(blue), elevation = ButtonDefaults.elevatedButtonElevation(6.dp),
           ){
               Text(text = "FOUND  SOMETHING?",
                   Modifier.padding(7.dp),
                   fontSize = 17.sp,
                   color = Color.White)
           }
       }
     }
    }
