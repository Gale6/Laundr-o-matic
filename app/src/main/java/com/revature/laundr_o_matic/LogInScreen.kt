package com.revature.laundr_o_matic

import android.content.Intent

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
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
            .background(MaterialTheme.colors.surface, RectangleShape)
            .fillMaxSize()
            .background(color = colorResource(id = R.color.lightCream))
    )
    {

// Landr-o-matic

//        val context = LocalContext.current
//        val typeface = ResourcesCompat.getFont(context, R.font.fresh_lychee)

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Laundr-o-matic",
            fontSize = 45.sp,
            color = colorResource(id = R.color.customDarkBrown),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 5.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Background of washing machine image

            // Washing machine image
            Image(
                painter = painterResource(id = R.drawable.washing_machine),
                contentDescription = "Kawaii washing machine",
                Modifier.size(200.dp)
            )



        Spacer(modifier = Modifier.height(50.dp))

        // Username surrounding box
        Surface(
            modifier = Modifier
//                .height(30.dp)
                .width(350.dp),
            shape = RectangleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
        )
        {
            // Username box input
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                colors = TextFieldDefaults.
                outlinedTextFieldColors(

                    focusedBorderColor = colorResource(id = R.color.customDarkBrown),
                    focusedLabelColor = colorResource(id = R.color.customDarkBrown)
                ),
            )
//                    (colorResource(id = R.color.mintGreen))


        }

        Spacer(modifier = Modifier.height(20.dp))

        // Password surrounding box
        Surface(
            modifier = Modifier
//                .height(20.dp)
                .width(350.dp),
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

                colors = TextFieldDefaults.
                outlinedTextFieldColors(

                    focusedBorderColor = colorResource(id = R.color.customDarkBrown),
                    focusedLabelColor = colorResource(id = R.color.customDarkBrown)),

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
        Spacer(modifier = Modifier.height(10.dp))

        // Login button
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.tealGreen)
            ),

            modifier = Modifier.height(60.dp),
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
                fontSize = 30.sp,
                color = colorResource(id = R.color.customDarkBrown),
                textAlign = TextAlign.Center
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        // Register for account button



        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.tealGreen)
            ),
            modifier = Modifier
                .height(60.dp),
            onClick = { navController.navigate(Screen.Registration.route) },
        )
//        button_name.setBackgroundResource(R.drawable.custom_button_file_name)


        {
            Text(
                text = "Register For Account",
                fontSize = 30.sp,
                color = colorResource(id = R.color.customDarkBrown),
                textAlign = TextAlign.Center
            )
        }
    }
}

fun checkLoginInfo (inUsername:String,inPassword:String): Boolean {
    return (inUsername == "user" && inPassword == "pass")

}


@Preview
@Composable
fun PreviewLogInScreen()
{
    LogInScreen(navController = rememberNavController())
}