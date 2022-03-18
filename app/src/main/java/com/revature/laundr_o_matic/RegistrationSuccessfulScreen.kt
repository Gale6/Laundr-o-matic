package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegistrationSuccessfulScreen(navController: NavController)
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(MaterialTheme.colors.surface, RectangleShape)
            .fillMaxSize()
            .background(color = colorResource(id = R.color.lightCream))
    )
    {

        Text("Congratulations!",
            fontSize = 40.sp,
            color = colorResource(id = R.color.animalCrossingGreen),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text("Your registration was successful!",
            fontSize = 25.sp,
            color = colorResource(id = R.color.customDarkBrown))

        Spacer(modifier = Modifier.height(50.dp))


            // Washing machine image
            Image(painter = painterResource(id = R.drawable.washing_machine),
                contentDescription = "wow")



        Spacer(modifier = Modifier.height(50.dp))

        val context = LocalContext.current

        // Register for account button
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.tealGreen)
            ),
            modifier = Modifier
                .height(60.dp)
                .width(360.dp),
            onClick = { navController.navigate(Screen.Login.route)})

        {
            Text(
                text = "Click here to log back in",
                fontSize = 27.sp,
                color = colorResource(id = R.color.customDarkBrown)
            )
        }
    }
}

@Preview
@Composable
fun PreviewRegistrationSuccessfulScreen()
{
    RegistrationSuccessfulScreen(navController = rememberNavController())
}
