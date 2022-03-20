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
import androidx.compose.ui.res.colorResource
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
import com.revature.laundr_o_matic.viewmodel.MainViewModel

//Shows a list of machines for selecting reservations
@Composable
fun MachineReservationScreen(navController: NavController, viewModel:MainViewModel)
{


    //var viewModel = MainViewModel()

    Column (Modifier.background(color = colorResource(id = R.color.lightCream))){
        TopAppBar(title = {Text("Select a Machine", color = colorResource(id = R.color.customDarkBrown))}, backgroundColor = colorResource(id = R.color.animalCrossingGreen))


        //LazyColumn state
        var state = rememberLazyListState()

        //Lazy Column of all our machines -
        //needs to be updated for functionality with Machine Manager
        LazyColumn(state = state){

            //for each item in the machine array
            items(viewModel.machineManager.getMachines().size)
            {
                var machine = viewModel.machineManager.getMachine(it)
                //Image ID based on if machine is Dryer or Washer -
                //needs to be updated//
                var machineImage:Int = if (machine is Washer) R.drawable.grey_washing_machine_1 else R.drawable.grey_dryer_icon_2

                //Row displaying machine
                Row(modifier = Modifier
                    .background(color = colorResource(id = R.color.lightCream))
                    .clickable {
                        viewModel.selectedMachine = machine!!
                        navController.navigate(Screen.MachineDetails.route)
                    }) {

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
                        var sName:String = if (machine is Washer ) "Washer" else "Dryer"

                        Row(modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()) {
                            Text(
                                sName, //machineArray[it],
                                style = MaterialTheme.typography.h5,
                                color = colorResource(id = R.color.brownGrey)
                            )

                            Spacer(Modifier.size(20.dp))

                            Text(
                                "Machine ID: ${machine?.id}",
                                 style = MaterialTheme.typography.h5,
                                color = colorResource(id = R.color.brownGrey)
                            )
                        }

                        Spacer(Modifier.size(10.dp))

                        //Row containing the details of the machine -
                        //needs to be updated
                        Row(modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()) {
                            Text("Cost: \$${machine?.nCost}", color = colorResource(id = R.color.brownGrey))
                            Spacer(Modifier.size(10.dp))
                            Text("Load: ${machine?.nLoadSize}", color = colorResource(id = R.color.brownGrey))
                            Spacer(Modifier.size(10.dp))
                            Text("Time: ${machine?.nRunTime}", color = colorResource(id = R.color.brownGrey))

                        }
                    }

                }

                Divider(color = colorResource(id = R.color.tealGreen), thickness = 2.dp)

            }

        }


    }




}
@Preview
@Composable
fun PreviewReservation()
{
    MachineReservationScreen(navController = rememberNavController(),MainViewModel())
}