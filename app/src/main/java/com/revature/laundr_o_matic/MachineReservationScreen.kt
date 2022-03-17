package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.revature.laundr_o_matic.model.MachineManager
import com.revature.laundr_o_matic.model.Washer
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

//Shows a list of machines for selecting reservations
@Composable
fun MachineReservationScreen(navController: NavController)
{


    val machines = MachineManager()

    Column {

        //TopBar of our screen
        TopAppBar(title = {Text("Select a Machine")})

        //LazyColumn state
        var state = rememberLazyListState()

        //Lazy Column of all our machines -
        //needs to be updated for functionality with Machine Manager
        LazyColumn(state = state){

            //for each item in the machine array
            items(machines.getMachines().size)
            {

                //Image ID based on if machine is Dryer or Washer -
                //needs to be updated//
                var machineImage:Int = if (machines.getMachine(it) is Washer) R.drawable.washer else R.drawable.dryer

                //Row displaying machine
                Row(modifier = Modifier.background(MaterialTheme.colors.background)
                    .clickable {
                        navController.navigate(Screen.MachineDetails.route)}) {

                    //Image of machine
                    Image(
                        painter = painterResource(id = machineImage),
                        contentDescription = "Machine Icon",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(10.dp)
                    )

                    //Column of the machine's name and details
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        //Machine's name -
                        //needs to be updated
                        var sName:String = if (machines.getMachine(it) is Washer ) "Washer" else "Dryer"

                        Row(modifier = Modifier.padding(5.dp)
                            .fillMaxWidth()) {
                            Text(
                                sName, //machineArray[it],
                                fontSize = 20.sp
                            )

                            Spacer(Modifier.size(20.dp))

                            Text(
                                "Machine ID: ${machines.getMachine(it)?.id}",
                                fontSize = 20.sp
                            )
                        }

                        Spacer(Modifier.size(10.dp))

                        //Row containing the details of the machine -
                        //needs to be updated
                        Row(modifier = Modifier.padding(5.dp)
                            .fillMaxWidth()) {
                            Text("Cost: \$${machines.getMachine(it)?.nCost}")
                            Spacer(Modifier.size(10.dp))
                            Text("Load: ${machines.getMachine(it)?.nLoadSize}")
                            Spacer(Modifier.size(10.dp))
                            Text("Time: ${machines.getMachine(it)?.nRunTime}")
                        }
                    }

                }

                //Divider for spacing between machines
                Divider(color = Color.Gray)
            }

        }


    }




}
@Preview
@Composable
fun PreviewReservation()
{
    MachineReservationScreen(navController = rememberNavController())
}