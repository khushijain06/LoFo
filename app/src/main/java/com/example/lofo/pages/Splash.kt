package com.example.lofo.pages

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.lofo.MainActivity
import com.example.lofo.R
import com.example.lofo.ui.theme.black
import kotlinx.coroutines.delay
class Splash : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                SplashScreen()
            }
    }
}
@Preview
@Composable
private fun SplashScreen(){
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        delay(2000)
        context.startActivity(Intent(context, MainActivity::class.java))
    }
     Box(modifier = Modifier
         .fillMaxSize()
         .background(black), contentAlignment = Alignment.Center) {
         Image(painter = painterResource(id = R.drawable.logo), contentDescription ="" )
     }
}