package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegistrationScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colors.surface, RectangleShape)
            .size(900.dp)
    )
    {

        Text("Registration", fontSize = 40.sp)

        Spacer(modifier = Modifier.height(50.dp))

        // Username surrounding box
        Surface(
            modifier = Modifier
//                .height(30.dp)
                .width(300.dp),
            shape = RectangleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        )
        {
            // Username box input
            var text by remember { mutableStateOf("") }

            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter your username") }
            )

        }

        Spacer(modifier = Modifier.height(50.dp))

        // Password surrounding box
        Surface(
            modifier = Modifier
//                .height(20.dp)
                .width(300.dp),
            shape = RectangleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        )
        {
            // Password box input
            var password by rememberSaveable { mutableStateOf("") }

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter your desired password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
        // Re-enter password surrounding box
        Surface(
            modifier = Modifier
//                .height(20.dp)
                .width(300.dp),
            shape = RectangleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        )
        {
            // Password box input
            var password by rememberSaveable { mutableStateOf("") }

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Please enter your password again") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

        }
        Spacer(modifier = Modifier.height(50.dp))

        val context = LocalContext.current

        // Registration button
        Button(
            modifier = Modifier.height(50.dp),
            onClick = {navController.navigate(Screen.RegistrationSuccessful.route)})

        {
            Text(
                text = "Register",
                fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun PreviewRegistrationScreen() {
    RegistrationScreen(navController = rememberNavController())
}