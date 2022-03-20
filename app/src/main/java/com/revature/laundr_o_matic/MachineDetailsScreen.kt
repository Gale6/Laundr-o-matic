package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.revature.laundr_o_matic.model.AbstractMachine
import com.revature.laundr_o_matic.model.MachineManager
import com.revature.laundr_o_matic.model.Washer
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme
import com.revature.laundr_o_matic.viewmodel.MainViewModel

//Shows the details of a selected machine
@Composable
fun MachineDetailsScreen(navController: NavController,viewModel:MainViewModel)
{

    //Temp machine for placeholder -
    //needs to be updated\
//    val machineManager = MachineManager()
    val machine = viewModel.selectedMachine


    Column(
        Modifier.background(
            color = colorResource(id = R.color.lightCream)
        )
    )
    {
        TopAppBar(
            title =
            { Text("Machine Details", color = colorResource(id = R.color.customDarkBrown)) },
            backgroundColor = colorResource(id = R.color.animalCrossingGreen)
        )

        Column(Modifier.fillMaxSize()) {


            Spacer(modifier = Modifier.height(40.dp))

          //Image of the Machine Selected - needs to be updated
          var machineImage:Int = if (machine is Washer) R.drawable.grey_washing_machine_1 else R.drawable.grey_dryer_1

          Image(painter = painterResource(id = machineImage),
              contentDescription = "Machine Image",
              modifier = Modifier
                  .size(250.dp)
                  .padding(20.dp)
                  .align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(10.dp))
            
                 //Column holding machine Information
            Column(modifier = Modifier
                .padding(10.dp)
                .border(5.dp, color = colorResource(id = R.color.brownGrey),
                    RoundedCornerShape(5.dp)
                )
                //.size(width =  250.dp, height = 200.dp)
                .fillMaxWidth(.75f)
                .align(Alignment.CenterHorizontally)){

                Spacer(Modifier.size(10.dp))
                
                //Row displaying type of machine
                Row(modifier = Modifier.fillMaxWidth(.9f)
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally)) {

                    val sType = if (machine is Washer) "Washer" else "Dryer"
                    Text(text = sType,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.brownGrey))
                }     

                  //Row containing our Machine's Unique ID - needs to be updated
                Row(modifier = Modifier.fillMaxWidth(.9f)
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally)) {

                    Text(text = "Machine ID: ",
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Left,
                        color = colorResource(id = R.color.brownGrey))

                    Text(text = machine?.id.toString(),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        color = colorResource(id = R.color.brownGrey))
                }

                    Spacer(Modifier.size(10.dp))

                //Row containing the size of the Machine - needs to be updated
                Row(modifier = Modifier.fillMaxWidth(.9f)
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally)) {

                    Text(text = "Size: ",
                        style = MaterialTheme.typography.body1,
                        color = colorResource(id = R.color.customDarkBrown))

                    Text(text = machine?.nLoadSize.toString(),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        color = colorResource(id = R.color.brownGrey))
                }
                    Spacer(Modifier.size(10.dp))

                //Row containing the price of the Machine - needs to be updated
                Row(modifier = Modifier.fillMaxWidth(.9f)
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally)) {

                    Text(text = "Price: ",
                        style = MaterialTheme.typography.body1,
                        color = colorResource(id = R.color.customDarkBrown))

                    Text(text = "\$${machine?.nCost}",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        color = colorResource(id = R.color.brownGrey))
                }

                    Spacer(Modifier.size(10.dp))

                      //Row containing the cycle length of the Machine - needs to be updated
                Row(modifier = Modifier.fillMaxWidth(.9f)
                    .padding(5.dp,10.dp)
                    .align(Alignment.CenterHorizontally)) {

                    Text(text = "Time: ",
                        style = MaterialTheme.typography.body1,
                        color = colorResource(id = R.color.brownGrey))

                    Text(text = "${machine?.nRunTime} min",
                        style = MaterialTheme.typography.body1
                        , modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        color = colorResource(id = R.color.brownGrey))
                }
                

            }
            
          //Button to start reservation of the machine - needs to be updated
          Button(colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                 onClick = { navController.navigate(Screen.ReservationTime.route) },
              modifier=Modifier.padding(10.dp)
                  .fillMaxWidth(.75f)
                  .height(50.dp)
                  .align(Alignment.CenterHorizontally)){
              Text("Reserve",
                  modifier = Modifier.fillMaxWidth(),
                  textAlign = TextAlign.Center,
                  color = colorResource(id = R.color.customDarkBrown))
          }
           
         

        }


    }
}
@Preview
@Composable
fun PreviewMachineDetails()
{
    MachineDetailsScreen(navController = rememberNavController(), MainViewModel())
}