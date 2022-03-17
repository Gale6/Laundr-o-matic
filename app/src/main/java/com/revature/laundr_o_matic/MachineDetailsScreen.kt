package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

//Shows the details of a selected machine
@Composable
fun MachineDetailsScreen(navController: NavController)
{

    Column {

        //Top Bar for the screen
        TopAppBar(title = {Text("Machine Details")})

        //Image of the Machine Selected - needs to be updated
        Image(painter = painterResource(id = R.drawable.washer),
            contentDescription = "Machine Image",
            modifier = Modifier
                .size(250.dp)
                .padding(20.dp)
                .align(Alignment.CenterHorizontally))

        //Column holding machine Information
        Column(modifier = Modifier
            .padding(20.dp)
            .border(5.dp, Color.Black,
                RoundedCornerShape(5.dp)
            )
            .size(width =  250.dp, height = 200.dp)
            .align(Alignment.CenterHorizontally)){

            Spacer(Modifier.size(10.dp))

            //Row containing our Machine's Unique ID - needs to be updated
            Row(modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp)) {

                Text(text = "Machine: ", fontSize = 20.sp)
                Text(text = "Washer 1", fontSize = 20.sp, modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Right)
            }

            Spacer(Modifier.size(10.dp))

            //Row containing the size of the Machine - needs to be updated
            Row(modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp)) {

                Text(text = "Size: ", fontSize = 20.sp)
                Text(text = "20 loads", fontSize = 20.sp, modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Right)
            }

            Spacer(Modifier.size(10.dp))

            //Row containing the price of the Machine - needs to be updated
            Row(modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp)) {

                Text(text = "Price: ", fontSize = 20.sp)
                Text(text = "$5.00", fontSize = 20.sp, modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Right)
            }

            Spacer(Modifier.size(10.dp))

            //Row containing the cycle length of the Machine - needs to be updated
            Row(modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp)) {

                Text(text = "Time: ", fontSize = 20.sp)
                Text(text = "50 min", fontSize = 20.sp, modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Right)
            }

        }

        //Button to start reservation of the machine - needs to be updated
        Button(onClick = { navController.navigate(Screen.ReservationTime.route) },
            modifier=Modifier.padding(10.dp)
                .fillMaxWidth(.75f)
                .height(50.dp)
                .align(Alignment.CenterHorizontally)){
            Text("Reserve",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
        }

    }


}
@Preview
@Composable
fun PreviewMachineDetails()
{
    MachineDetailsScreen(navController = rememberNavController())
}