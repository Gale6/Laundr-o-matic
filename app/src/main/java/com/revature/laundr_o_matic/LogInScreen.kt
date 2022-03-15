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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// Washing machine icon
@Composable
fun LogInScreen(navController: NavController) =

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

        Spacer(modifier = Modifier.height(32.dp))

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

        Spacer(modifier = Modifier.height(45.dp))

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
            var password by rememberSaveable { mutableStateOf("") }

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))

        val context = LocalContext.current

        // Login button
        Button(
            modifier = Modifier.height(50.dp),
            onClick = { context.startActivity(Intent()) })
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
            onClick = { navController.navigate(Screen.Registration.route)})
        {
            Text(
                text = "Register For New Account",
                fontSize = 20.sp
            )
        }
    }


@Preview
@Composable
fun PreviewLogInScreen() {
    LogInScreen(navController = rememberNavController())
}