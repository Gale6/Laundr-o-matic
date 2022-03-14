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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class RegistrationSuccessful : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent ()
        {
            RegistrationSuccessfulScreen()
        }
    }
}

@Composable
fun RegistrationSuccessfulScreen()
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colors.surface, RectangleShape)
            .size(900.dp)
    )
    {

        Text("Congratulations", fontSize = 40.sp)

        Spacer(modifier = Modifier.height(40.dp))

        Text("Your registration was successful!", fontSize = 25.sp)

        Spacer(modifier = Modifier.height(50.dp))

        Surface(
            modifier = Modifier.size(200.dp),
            shape = RectangleShape
        )
        {
            // Washing machine image
            Image(painter = painterResource(id = R.drawable.washing_machine),
                contentDescription = "wow")
        }


        Spacer(modifier = Modifier.height(50.dp))

        val context = LocalContext.current

        // Register for account button
        Button(
            modifier = Modifier.height(50.dp),
            onClick = { context.startActivity(Intent(context, MainActivity::class.java)) })

        {
            Text(
                text = "Click here to log back in",
                fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun PreviewRegistrationSuccessfulScreen()
{
    RegistrationSuccessfulScreen()
}
