package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

@Composable
fun UserProfileScreen(navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(50.dp))
        Image(
            painter = painterResource(R.drawable.usericon),
            contentDescription = "userIcon",
            modifier = Modifier
                .size(150.dp)
        )
        Spacer(modifier = Modifier.size(50.dp))

        var username by remember { mutableStateOf("Username") }
        TextField(value = username,
            onValueChange = { username = it },
            label = { Text(text = "Enter Username") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        var password by remember { mutableStateOf("Enter Password") }
        var passwordVisibility by remember { mutableStateOf(false) }
        val icon = if (passwordVisibility)
            painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
        else
            painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)


        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Password") },
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { /*TODO*/ }, modifier = Modifier.width(150.dp)) {
            Text(text = "Edit profile")
        }

        Spacer(modifier = Modifier.height(32.dp))
        Row{
            Button(onClick = {navController.navigate(Screen.Wallet.route) }, modifier = Modifier.width(100.dp)) {
                Text(text = "Wallet")
            }
            Spacer(modifier = Modifier.width(32.dp))
            Button(onClick = {navController.navigate(Screen.MainMenu.route)}, modifier = Modifier.width(100.dp)) {
                Text(text = "Main")
            }
        }


        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = { /*todo*/ }, modifier = Modifier
            .width(100.dp)
           ) {
            Text(text = "Sign out")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2()
{
    LaundromaticTheme()
    {
        UserProfileScreen(navController = rememberNavController())
    }
}