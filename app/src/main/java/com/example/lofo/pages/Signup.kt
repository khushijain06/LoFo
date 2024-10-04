package com.example.lofo.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lofo.AuthViewModel
import com.example.lofo.R

@Composable
fun Signup(modifier: Modifier=Modifier,navController: NavController,authViewModel: AuthViewModel){
        var email by remember {
            mutableStateOf("")
        }
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Card(
                modifier= Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(),
            ) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "sign up Page")
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(value = email, onValueChange = {
                        email = it
                    },
                        label = {
                            Text(text = "Email")
                        }
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {}) {
                    Text(text = "sign up")
                }
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(onClick ={ navController.navigate("log in")}) {
                    Text(text = "Already have an account? log in")
                }

            }
        }
    }

}