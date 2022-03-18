package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition.Companion.None
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.writeToFile

@Composable
fun RegistrationScreen(navController: NavController) {

    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var rePassword by rememberSaveable { mutableStateOf("") }
    var matchText by rememberSaveable{ mutableStateOf("")}
    var passwordVisibility by remember { mutableStateOf(false) }
    var userNameInvalidText by rememberSaveable{ mutableStateOf("")}
    var userPasswordInvalidText by rememberSaveable{ mutableStateOf("")}

    val icon = if (passwordVisibility) {
        painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
    } else {
        painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)
    }
    var passwordVisibility1 by remember { mutableStateOf(false) }
    val icon1 = if (passwordVisibility1) {
        painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
    } else {
        painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)
    }

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .background(color = colorResource(id = R.color.lightCream), RectangleShape)
            .fillMaxSize()
    )
    {

        Text("Registration",
            fontSize = 40.sp,
            color = colorResource(id = R.color.customDarkBrown),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(25.dp))

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
                 onValueChange = {
                     username = it
                     userNameInvalidText = if (username.length >= 4){
                         ""
                     }else{
                         "Username has to be longer then 4 character"
                     }
                                 },
                label = { Text("Enter your username") },
                        colors = TextFieldDefaults.
                        outlinedTextFieldColors(

                        focusedBorderColor = colorResource(id = R.color.customDarkBrown),
                focusedLabelColor = colorResource(id = R.color.customDarkBrown)
                        ),
            )
        }
        Text(text = userNameInvalidText, color = Color.Red)

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


            TextField(
                value = password,
                onValueChange = {
                    password = it
                    userPasswordInvalidText = if (password.length >= 4){
                        ""
                    }else{
                        "Password has to be longer then 4 character"
                    }
                },
                label = { Text("Enter your desired password") },
                colors = TextFieldDefaults.
                outlinedTextFieldColors(

                    focusedBorderColor = colorResource(id = R.color.customDarkBrown),
                    focusedLabelColor = colorResource(id = R.color.customDarkBrown)
                    ),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            painter = icon,
                            contentDescription = "visibility icon"
                        )
                    }
                },
                visualTransformation = if(passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
        Text(text = userPasswordInvalidText, color = Color.Red)

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

            TextField(
                colors = TextFieldDefaults.
                outlinedTextFieldColors(

                    focusedBorderColor = colorResource(id = R.color.customDarkBrown),
                    focusedLabelColor = colorResource(id = R.color.customDarkBrown)
                ),
                value = rePassword,
                onValueChange = {

                    rePassword = it
                    matchText = if (rePassword != password){
                        "re-entered password does not match"
                    }else{
                        ""
                    }
                                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility1 = !passwordVisibility1
                    }) {
                        Icon(
                            painter = icon1,
                            contentDescription = "visibility icon1"
                        )
                    }
                },

                label = { Text("Re-enter your password again") },

                visualTransformation = if(passwordVisibility1) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

        }

        Text(text = matchText, color = Color.Red)


        // Registration button
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.tealGreen)
            ),
            modifier = Modifier.width(200.dp),
            onClick = {
                if(rePassword == password && username.length >= 4 && password.length >= 4){
                    val userObject = User(username = username, password = password)
                    writeToFile(context = context,userObject)
                    navController.navigate(Screen.RegistrationSuccessful.route)
                }
            }

        )

        {
            Text(
                text = "Register",
                fontSize = 10.sp,
                color = colorResource(id = R.color.customDarkBrown)
            )
        }
    }
}

@Preview
@Composable
fun PreviewRegistrationScreen() {
    RegistrationScreen(navController = rememberNavController())
}