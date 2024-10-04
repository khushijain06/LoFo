package com.example.lofo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthState
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthState

class  AuthViewModel:ViewModel(){
    private val auth : FirebaseAuth=FirebaseAuth.getInstance()
    private val _authState=MutableLiveData<AuthState>()
    val authState:LiveData<AuthState>= _authState
            init{
                checkAuthStatus()
            }
fun checkAuthStatus
}