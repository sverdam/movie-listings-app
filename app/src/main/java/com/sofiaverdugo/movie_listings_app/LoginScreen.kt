package com.sofiaverdugo.movie_listings_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sofiaverdugo.movie_listings_app.ui.theme.MovielistingsappTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun LoginScreen(onLoginOk: () -> Unit, onSignUp: () -> Unit) {
    var user by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf(false)}

        Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF12121F)).padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Move Listings",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )
        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("User", color = Color.White) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            isError = error,
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", color = Color.White) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth(),
            isError = error
        )
        Button(
            onClick = {
                if(user.isBlank() || password.isBlank()){
                    error = true }
                else {
                    Firebase.auth.signInWithEmailAndPassword(user.trim(), password.trim()).addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            onLoginOk() }
                        else {
                            error = true
                        }
                    }

                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Log In")

        }

            TextButton(onClick = onSignUp) {
                Text("Don't have an account yet? Sign Up")
            }


    }

}

@Preview
@Composable
fun LoginScreenPreview(){
    MovielistingsappTheme{
        LoginScreen(onLoginOk = { }, onSignUp = { })

    }
}