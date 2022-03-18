package com.revature.laundr_o_matic

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme
import com.revature.laundr_o_matic.ui.theme.writeToFile
import com.revature.laundr_o_matic.viewmodel.MainViewModel

@Composable
fun UserProfileScreen(navController: NavController, viewModel: MainViewModel) {

    val context = LocalContext.current
    var password by rememberSaveable { mutableStateOf ("") }
    var rePassword by rememberSaveable { mutableStateOf("") }
    var matchText by rememberSaveable{ mutableStateOf("")}
    var userPasswordInvalidText by rememberSaveable{ mutableStateOf("")}
    var passwordVisibility by remember { mutableStateOf(false) }
    var passwordChanged by rememberSaveable{ mutableStateOf("")}

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
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(25.dp))
        Image(
            painter = painterResource(R.drawable.usericon),
            contentDescription = "userIcon",
            modifier = Modifier
                .size(150.dp)
        )
        Spacer(modifier = Modifier.size(25.dp))
        Surface(
            modifier = Modifier
//                .height(20.dp)
                .width(300.dp),
            shape = RectangleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            TextField(
                value = password,
                onValueChange = {
                    password = it
                    userPasswordInvalidText = if (password.length >= 4) {
                        ""
                    } else {
                        "Password has to be longer then 4 character"
                    }
                },
                label = { Text("Enter your desired password") },
                colors = TextFieldDefaults.outlinedTextFieldColors(

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
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),

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
        Text(text = passwordChanged)

        Button(onClick = {
            if(rePassword == password && password.length >= 4){
                viewModel.user!!.password = password
                writeToFile(context = context,viewModel.user!!)
                passwordChanged = "Password change successful"
            }
                         },
            modifier = Modifier.width(150.dp)) {
            Text(text = "Change password")
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

        Button(onClick = {
            viewModel.user = null
            navController.navigate(Screen.Login.route)
                         },
            modifier = Modifier
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
        UserProfileScreen(navController = rememberNavController(), viewModel = MainViewModel())
    }
}