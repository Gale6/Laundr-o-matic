package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.model.Washer
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme
import com.revature.laundr_o_matic.viewmodel.MainViewModel

//Screen showing Successful reservation of machine
@Composable
fun ReservationSuccessfulScreen(navController: NavController,viewModel:MainViewModel)
{
    viewModel.update()

    var context = LocalContext.current
    Column()
    {
        TopAppBar(
            title =
            { Text("Reservation Successful!",
                color = colorResource(id = R.color.customDarkBrown))}, backgroundColor = colorResource(id = R.color.animalCrossingGreen)
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.lightCream)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )
    {
        Spacer(Modifier.height(80.dp))

        Text(
            text = "Congratulations!",
            color = colorResource(id = R.color.customDarkBrown),
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))      
      
      var machine = viewModel.selectedMachine
        //Image ID based on if machine is Dryer or Washer -
        //needs to be updated//
        var machineImage:Int = if (machine is Washer) R.drawable.washer else R.drawable.dryer


        //Image of machine -
        //needs to be updated
        Image(painter = painterResource(id = machineImage),

            contentDescription = "Reservation Success",
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
        )


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Your reservation was a",
            color = colorResource(id = R.color.customDarkBrown),
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = "success!",
            color = colorResource(id = R.color.customDarkBrown),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
            onClick = { navController.navigate(Screen.MainMenu.route) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(60.dp)
                .width(350.dp)
        )
        {
            Text(
                "Return to Main Menu",
                color = colorResource(id = R.color.customDarkBrown),
                fontSize = 30.sp
            )
        }


    }
    }
}

@Preview
@Composable
fun PreviewReservationSuccessful()
{
    ReservationSuccessfulScreen(navController = rememberNavController(),MainViewModel())
}