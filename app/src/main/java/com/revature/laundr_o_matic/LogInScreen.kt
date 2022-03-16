package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// Washing machine icon
@Composable
fun LogInScreen(navController: NavController) {

    var username by remember { mutableStateOf ("") }
    var password by rememberSaveable { mutableStateOf ("") }
    var loginStat by rememberSaveable { mutableStateOf ("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colors.surface, RectangleShape)
            .size(900.dp)
    )
    {

// Landr-o-matic

//        val context = LocalContext.current
//        val typeface = ResourcesCompat.getFont(context, R.font.fresh_lychee)

        Text(
            text = "Laundr-o-matic",
            fontSize = 40.sp,
            fontFamily = FontFamily.Monospace
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Background of washing machine image
        Surface(
            modifier = Modifier.size(200.dp),
            shape = RectangleShape
        )
        {
            // Washing machine image
            Image(
                painter = painterResource(id = R.drawable.washing_machine),
                contentDescription = "Kawaii washing machine"
            )

        }

        Spacer(modifier = Modifier.height(30.dp))

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
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") }
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

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

            var passwordVisibility by remember { mutableStateOf(false) }
            val icon = if (passwordVisibility) {
                painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
            } else {
                painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)
            }

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            painter = icon,
                            contentDescription = "visibility icon"
                        )
                    }
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
        Text(text = loginStat)
        Spacer(modifier = Modifier.height(40.dp))

        // Login button
        Button(
            modifier = Modifier.height(50.dp),
            onClick = {
                if (checkLoginInfo(username,password)) {
                    navController.navigate(Screen.MainMenu.route)
                } else {
                    loginStat = "Invalid login information"
                }
            })
        {
            Text(
                text = "Login",
                fontSize = 20.sp
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        // Register for account button
        Button(
            modifier = Modifier.height(50.dp),
            onClick = { navController.navigate(Screen.Registration.route) })
        {
            Text(
                text = "Register For New Account",
                fontSize = 20.sp
            )
        }
    }
}

fun checkLoginInfo (inUsername:String,inPassword:String): Boolean {
    return (inUsername == "user" && inPassword == "pass")

}


@Preview
@Composable
fun PreviewLogInScreen() {
    LogInScreen(navController = rememberNavController())
}