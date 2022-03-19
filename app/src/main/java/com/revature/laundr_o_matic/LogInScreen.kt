package com.revature.laundr_o_matic

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.readFromFile
import com.revature.laundr_o_matic.ui.theme.writeToFile
import java.io.File
import com.revature.laundr_o_matic.viewmodel.MainViewModel



// Washing machine icon
@Composable
fun LogInScreen(navController: NavController, viewModel:MainViewModel) {

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val initUser = User("user","pass")

    writeToFile(context,initUser) //hard coding a user into local storage

    var username by remember { mutableStateOf ("") }
    var password by rememberSaveable { mutableStateOf ("") }
    var loginStat by rememberSaveable { mutableStateOf ("") }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(MaterialTheme.colors.surface, RectangleShape)
            .fillMaxSize()
            .background(color = colorResource(id = R.color.lightCream))
            .clickable { focusManager.clearFocus() }
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

        Spacer(modifier = Modifier.height(10.dp))

        // Background of washing machine image

            // Washing machine image
            Image(
                painter = painterResource(id = R.drawable.washing_machine),
                contentDescription = "Kawaii washing machine",
                Modifier.size(150.dp)
            )

        Spacer(modifier = Modifier.height(15.dp))

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
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                })
            )
//                    (colorResource(id = R.color.mintGreen))


        }

        Spacer(modifier = Modifier.height(10.dp))

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
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                    ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
        }))
        }
        Text(text = loginStat, color = Red)
        Spacer(modifier = Modifier.height(10.dp))

        // Login button
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.tealGreen)
            ),

            modifier = Modifier.height(60.dp),
            onClick = {

                if (checkLoginInfo(username,password,context,viewModel)) {
                    viewModel.user = readFromFile(filePath = "${context.filesDir.toString()}/${username}.ser")
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

fun checkLoginInfo (inUsername:String,inPassword:String,context: Context, viewModel:MainViewModel): Boolean {
    var filePath = "${context.filesDir.toString()}/${inUsername}.ser"
    var file = File(filePath)
    if ( !file.exists()){
        return false
    }
    val myUser = readFromFile(filePath = filePath)

    return if (myUser.password == inPassword)  {
        viewModel.user = myUser
        true
    } else {
        false
    }
    //return (myUser.password == inPassword)

}


@Preview
@Composable
fun PreviewLogInScreen()
{
    LogInScreen(navController = rememberNavController(),MainViewModel())
}