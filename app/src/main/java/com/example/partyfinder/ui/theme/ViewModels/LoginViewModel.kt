package com.example.partyfinder.ui.theme.ViewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.partyfinder.data.repositories.LocalUserRepository
import com.example.partyfinder.model.uiEvent.LoginUIEvent
import com.example.partyfinder.model.uiState.LoginUIState
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel(
    private val userRepository: LocalUserRepository,
    val localLoginEmail:String = ""
) : ViewModel() {

    private val TAG = LoginViewModel::class.simpleName

    private val _loginUIState = MutableStateFlow(LoginUIState())
    val loginUIState: StateFlow<LoginUIState> = _loginUIState.asStateFlow()

    var loginInProgress = mutableStateOf(false)

    var loginIsSuccessful = mutableStateOf(false)

    init {
        _loginUIState.update { currentState -> currentState.copy(
            email = localLoginEmail
        ) }
    }

    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                _loginUIState.update{ currentState -> currentState.copy(
                    email = event.email)}
                printState()
            }

            is LoginUIEvent.PasswordChanged -> {
                _loginUIState.update{ currentState -> currentState.copy(
                    password = event.password)}
                printState()
            }

            is LoginUIEvent.ForgotPasswordClicked -> {
                sendPasswordReset()
                Log.d(TAG, "ForgotPasswordComponent Clicked")
            }
        }
    }

    fun login(navigateToHomeScreen:()->Unit) {

        loginInProgress.value = true
        val email = _loginUIState.value.email
        val password = _loginUIState.value.password

        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_login_success")
                Log.d(TAG, "${it.isSuccessful}")

                if(it.isSuccessful){
                    loginInProgress.value = false
                    loginIsSuccessful.value = true
                    navigateToHomeScreen()
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Inside_login_failure")
                it.localizedMessage?.let { it1 -> Log.d(TAG, it1) }

                loginInProgress.value = false

            }

    }

    private fun sendPasswordReset() {
        val email = _loginUIState.value.email

        Firebase.auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Email sent.")
                }
                else{
                    Log.d(TAG, "Unable to send Email")
                }
            }
    }

    private fun printState(){
        Log.d(TAG, "InsideStack")
        Log.d(TAG, _loginUIState.value.toString())
    }
}