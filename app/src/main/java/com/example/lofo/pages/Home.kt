package com.example.lofo.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.lofo.AuthViewModel
import com.example.lofo.NavItem
import com.example.lofo.ui.theme.darkgrey
import com.example.lofo.ui.theme.white
import com.example.lofo.viewmodel.FoundItemViewModel
import com.example.lofo.viewmodel.LostItemViewModel




@Composable
fun Home(modifier: Modifier,navController: NavHostController,
         authViewModel: AuthViewModel,LviewModel: LostItemViewModel,FviewModel: FoundItemViewModel) {
    val navItemList= listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Lost Items", Icons.Default.Search),
        NavItem("Found Items", Icons.Default.LocationOn ),
        NavItem("Profile", Icons.Default.Person ),
    )
    var selectedindex by remember{
        mutableStateOf(0)
    }
    Scaffold (
        bottomBar ={
            NavigationBar(containerColor = darkgrey, contentColor = white) {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedindex==index,
                        onClick = { selectedindex=index },
                        icon = {navItem.icon },
                        label={
                            Text(text=navItem.label)
                        }
                    )
                }
            }
    }
    ){
            innerPadding-> ContentScreen(navController,modifier.padding(innerPadding),selectedindex,LviewModel,FviewModel )
    }
}
@Composable
 fun ContentScreen(navController: NavHostController,modifier: Modifier, selectedIndex:Int,
                   LviewModel: LostItemViewModel,FviewModel: FoundItemViewModel){
    when(selectedIndex) {
        0-> Main(navController,LviewModel,FviewModel)
        1-> LostItemDisplayScreen(modifier,LviewModel)
        2-> FoundItemDisplayScreen(modifier,FviewModel)
        3-> Profile()
    }
}

