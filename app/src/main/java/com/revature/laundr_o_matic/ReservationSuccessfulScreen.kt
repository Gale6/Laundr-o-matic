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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme
import com.revature.laundr_o_matic.viewmodel.MainViewModel

//Screen showing Successful reservation of machine
@Composable
fun ReservationSuccessfulScreen(navController: NavController,viewModel:MainViewModel)
{

    Column {

        //Top Bar of our Screen
        TopAppBar(title = {Text("Reservation Successful!")})

        Spacer(Modifier.padding(10.dp))

        //Image of machine -
        //needs to be updated
        Image(painter = painterResource(id = R.drawable.washer),
            contentDescription = "Reservation Success",
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp)
                .align(Alignment.CenterHorizontally))

        //Text displaying success
        Text(text = "Success!",
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), fontSize = 30.sp, textAlign = TextAlign.Center)

        //Button to leave screen for main menu
        Button(onClick = {navController.navigate(Screen.MainMenu.route)},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(40.dp)
                .fillMaxWidth(.75f)) {

            //Text on Button
            Text("Return to Main Menu")
        }
    }
}

@Preview
@Composable
fun PreviewReservationSuccessful()
{
    ReservationSuccessfulScreen(navController = rememberNavController(),MainViewModel())
}