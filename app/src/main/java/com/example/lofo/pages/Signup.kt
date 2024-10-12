package com.example.lofo.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lofo.AuthState
import com.example.lofo.AuthViewModel
import com.example.lofo.R

@Composable
fun Signup(modifier: Modifier=Modifier,navController: NavController,authViewModel: AuthViewModel) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf(" ")
    }
    val authState = authViewModel.authState.observeAsState()
    val context= LocalContext.current
    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated->navController.navigate("home")
            is AuthState.Error->Toast.makeText(context,(authState.value as  AuthState.Error).message,Toast.LENGTH_SHORT).show()
            else->Unit
        }
    }
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background((Color(0xffffffff)))
            ) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Sign up", fontSize = 32.sp, color = Color(0xff530077))
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Create your account", fontSize = 12.sp, color = Color(0xff530077))
                    Spacer(modifier = Modifier.height(26.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "Email") },
                        shape = RoundedCornerShape(24.dp),
                        colors =  OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xffaf00fd),
                            focusedTextColor = Color(0xff000000),
                            unfocusedBorderColor = Color(0xfff1d6fd),
                            unfocusedTextColor = Color(0xff000000)
                        ),
                        prefix = {
                            Icon(imageVector = Icons.Default.Email, contentDescription ="Email icon",
                                tint = Color(0xfff1d6fd))
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(value = password, onValueChange = {
                        password = it
                    },
                        label = {
                            Text(text = "Password")
                        },
                        shape = RoundedCornerShape(24.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xffaf00fd),
                            focusedTextColor = Color(0xff000000),
                            unfocusedTextColor = Color(0xff000000),
                            unfocusedBorderColor = Color(0xfff1d6fd)
                        ),
                        prefix = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Password icon",
                                tint = Color(0xfff1d6fd)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(22.dp))
                    Button(onClick = {
                        authViewModel.signup(email, password)
                    }, enabled = authState.value!=AuthState.Loading,
                        modifier = Modifier.padding(8.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors( Color(0xffe2a0ff))
                        ) {
                        Text(text = "Create account",color=Color(0xffffffff))
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    TextButton(onClick = { navController.navigate("login") }) {
                        Text(text = "Already have an account? Login", color = Color(0xffaf00fd))
                    }
                }
            }
        }
    }

