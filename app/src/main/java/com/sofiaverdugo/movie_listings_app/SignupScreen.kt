package com.sofiaverdugo.movie_listings_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.sofiaverdugo.movie_listings_app.ui.theme.MovielistingsappTheme

@Composable
fun SignupScreen(
    onSignupOK: () -> Unit,
    onCancel: () -> Unit
) {
    var user by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var verify by rememberSaveable { mutableStateOf("") }
    var errorMsg by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF12121F)).padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )

        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("User", color = Color.White) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
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
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = verify,
            onValueChange = { verify = it },
            label = { Text("Verify password", color = Color.White) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth()
        )

        if (errorMsg.isNotEmpty()) {
            Text(
                text = errorMsg,
                color = MaterialTheme.colorScheme.error
            )
        }
        Button(
            onClick = {
                errorMsg = validateSignup(user, password, verify)
                if (errorMsg.isEmpty()) {
                    Firebase.auth.createUserWithEmailAndPassword(user.trim(), password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                onSignupOK()
                            } else {
                                errorMsg = task.exception?.message ?: "Something went wrong creating your account :("
                            }
                        }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse", color = Color.White)
        }
        TextButton(onClick = onCancel) {
            Text("I already have an account")
        }

    }
}

fun validateSignup(
    user: String,
    password: String,
    verify: String
): String {
    if (user.isBlank() || password.isBlank() || verify.isBlank()) {
        return "Fill in all the required fields"
    }
    if (password.length < 6) {
        return "Password should be at least 6 characters long"
    }
    if (password != verify) {
        return "Passwords should match"
    }
    return ""
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    MovielistingsappTheme() {
        SignupScreen(onSignupOK = { }, onCancel = { })
    }
}