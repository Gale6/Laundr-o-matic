package com.revature.laundr_o_matic

import android.util.Log
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
import com.revature.laundr_o_matic.model.MachineManager
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme
import com.revature.laundr_o_matic.ui.theme.writeToFile
import com.revature.laundr_o_matic.viewmodel.MainViewModel

@Composable
fun UserProfileScreen(navController: NavController, viewModel: MainViewModel) {

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    var password by rememberSaveable { mutableStateOf("") }
    var rePassword by rememberSaveable { mutableStateOf("") }
    var matchText by rememberSaveable { mutableStateOf("") }
    var userPasswordInvalidText by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var passwordChanged by rememberSaveable { mutableStateOf("") }

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
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.lightCream))
            .fillMaxSize()
            .clickable { focusManager.clearFocus() },
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.size(50.dp))
        Image(
            painter = painterResource(R.drawable.grey_user_icon),
            contentDescription = "userIcon",
            modifier = Modifier
                .size(150.dp)
        )


        Spacer(modifier = Modifier.height(16.dp))

        var password by remember { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }
        val icon = if (passwordVisibility)
            painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
        else
            painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)


        TextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(

                focusedBorderColor = colorResource(id = R.color.customDarkBrown),
                focusedLabelColor = colorResource(id = R.color.customDarkBrown)
            ),
            value = password,
            onValueChange = {
                password = it
                if (password.length<4){
                    userPasswordInvalidText = "user password can not be shorter then 4"
                }else{
                    userPasswordInvalidText = ""
                }
                            },
            label = { Text(text = "Password") },
            trailingIcon =
            {
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
        Text(text = userPasswordInvalidText, color = Color.Red)
        TextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(

                focusedBorderColor = colorResource(id = R.color.customDarkBrown),
                focusedLabelColor = colorResource(id = R.color.customDarkBrown)
            ),
            value = rePassword,
            onValueChange = {

                rePassword = it
                matchText = if (rePassword != password) {
                    "re-entered password does not match"
                } else {
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

            visualTransformation = if (passwordVisibility1) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }
            )
        )
        Text(text = matchText, color = Color.Red)
        Text(text = passwordChanged)
        Button(
            onClick = {
                focusManager.clearFocus()
                if (rePassword == password && password.length >= 4) {
                    viewModel.user!!.password = password
                    writeToFile(context = context, viewModel.user!!)
                    passwordChanged = "Password change successful"
                }
            },
            modifier = Modifier.wrapContentWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
        ) {
            Text(text = "Change password",
                color = colorResource(id = R.color.brownGrey
                ),
                fontSize = 30.sp,
                textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.size(25.dp))
        Surface(
            modifier = Modifier
//                .height(20.dp)
                .width(300.dp),
            shape = RectangleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        )
        {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                onClick = { navController.navigate(Screen.MainMenu.route) },
                modifier = Modifier.width(130.dp)
            )
            {
                Text(
                    text = "Main",
                    color = colorResource(id = R.color.brownGrey),
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Spacer(modifier = Modifier.height(50.dp))
        Surface(
            modifier = Modifier
//                .height(20.dp)
                .width(300.dp),
            shape = RectangleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        )
        {



            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                onClick = {
                    viewModel.user = null
                    navController.navigate(Screen.Login.route)
                },
                modifier = Modifier
                    .width(170.dp)
            )
            {
                Text(
                    text = "Sign out",
                    color = colorResource(id = R.color.brownGrey),
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
        }

//

    }

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview2()
{
    LaundromaticTheme()
    {
        UserProfileScreen(navController = rememberNavController(), viewModel = MainViewModel(
            MachineManager()
        ))
    }
}