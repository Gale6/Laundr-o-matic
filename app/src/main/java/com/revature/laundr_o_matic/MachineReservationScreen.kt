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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

//Shows a list of machines for selecting reservations
@Composable
fun MachineReservationScreen(navController: NavController)
{
    //temp list of machines
    var machineArray = ArrayList<String>()
    machineArray.add("Washer 1")
    machineArray.add("Washer 2")
    machineArray.add("Washer 3")
    machineArray.add("Washer 4")
    machineArray.add("Washer 5")
    machineArray.add("Washer 6")
    machineArray.add("Dryer 1")
    machineArray.add("Dryer 2")
    machineArray.add("Dryer 3")
    machineArray.add("Dryer 4")
    machineArray.add("Dryer 5")
    machineArray.add("Dryer 6")

    Column {

        //TopBar of our screen
        TopAppBar(title = {Text("Select a Machine")})

        //LazyColumn state
        var state = rememberLazyListState()

        //Lazy Column of all our machines -
        //needs to be updated for functionality with Machine Manager
        LazyColumn(state = state){

            //for each item in the machine array
            items(machineArray.size)
            {

                //Image ID based on if machine is Dryer or Washer -
                //needs to be updated
                var iMachine: Int = if (machineArray.get(it)
                        .startsWith('D')
                ) R.drawable.dryer else R.drawable.washer

                //Row displaying machine
                Row(modifier = Modifier.background(MaterialTheme.colors.background)
                    .clickable {
                        navController.navigate(Screen.MachineDetails.route)}) {

                    //Image of machine
                    Image(
                        painter = painterResource(id = iMachine),
                        contentDescription = "Machine Icon",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(10.dp)
                    )

                    //Column of the machine's name and details
                    Column {

                        //Machine's name -
                        //needs to be updated
                        Text(
                            machineArray[it], modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            fontSize = 20.sp)

                        Spacer(Modifier.size(10.dp))

                        //Row containing the details of the machine -
                        //needs to be updated
                        Row() {
                            Text("Cost: $5.00")
                            Spacer(Modifier.size(10.dp))
                            Text("Load: 20")
                            Spacer(Modifier.size(10.dp))
                            Text("Time: 50min")
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