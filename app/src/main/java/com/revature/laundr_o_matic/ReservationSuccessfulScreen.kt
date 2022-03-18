package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

@Composable
fun ReservationSuccessfulScreen(navController: NavController)
{
    var context = LocalContext.current
    Column()
    {
        TopAppBar(
            title = {
                Text("Reservation Successful!",
                    color = colorResource(id = R.color.customDarkBrown))},
            backgroundColor = colorResource(id = R.color.animalCrossingGreen)
        )

        Spacer(Modifier.height(20.dp))

        Image(painter = painterResource(id = R.drawable.washer),
            contentDescription = "Reservation Success",
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp)
                .align(Alignment.CenterHorizontally))

        Text(text = "Success!",
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.customDarkBrown),
        )

        Button(onClick = {navController.navigate(Screen.MainMenu.route)},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(40.dp)
                .fillMaxWidth(.75f),
        )
        {
            Text("Return to Main Menu")
        }



    }
}

@Preview
@Composable
fun PreviewReservationSuccessful()
{
    ReservationSuccessfulScreen(navController = rememberNavController())
}