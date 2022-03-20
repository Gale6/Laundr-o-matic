package com.revature.laundr_o_matic

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.revature.laundr_o_matic.model.DateSlot
import com.revature.laundr_o_matic.model.ReservedSlot
import com.revature.laundr_o_matic.model.Washer
import com.revature.laundr_o_matic.ui.theme.writeToFile
import com.revature.laundr_o_matic.viewmodel.MainViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun ReservationTimeScreen(navController: NavController,viewModel:MainViewModel)
{
    viewModel.update()

    viewModel.selectedDate = remember { mutableStateOf(viewModel.selectedMachine.reservations.days.first()) }

    Surface(modifier = Modifier
        .fillMaxSize(),
    color  = colorResource(id = R.color.lightCream)) {

    //Column to start our screen
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        //Top bar of screen
        TopAppBar(
            title = { Text("Reservation Time", color = colorResource(id = R.color.customDarkBrown)) },
            backgroundColor = colorResource(id = R.color.animalCrossingGreen))


        //Call our function that creates the Date Buttons
        dateSelection(viewModel)

        //Display the currently selected date
        Box(modifier=Modifier.fillMaxWidth())
        {
            Text(
                "Selected Date: \t${viewModel.selectedDate.value.Date}", modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color.Black, RoundedCornerShape(5.dp)), fontSize = 30.sp, textAlign = TextAlign.Center
            )
        }
        //Display our LazyColumn of times for the selected date
        TimeList(navController,viewModel)

    }
    }

}
@Composable
fun dateSelection( viewModel: MainViewModel)
{
    //Store our passed in date for use
    //var selectedDate =

    //Row for the Different Date Buttons
    Row(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){

        //for each day our reservation manager holds
        viewModel.selectedMachine.reservations.days.forEach {

            //Button for the day
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.tealGreen)
                ),onClick = {

                //On clicking a button, change our selected date to the new date
                viewModel.selectedDate.value = it
            },
                modifier = Modifier
                    .padding(5.dp)
                    .size(width = 75.dp, height = 35.dp)){

                //Display the date in the button
                //Text(it.Date.toString())
                Text(it.Date.format(DateTimeFormatter.ofPattern("dd/MM")))
            }

        }

    }

}


@Composable
fun TimeList(navController : NavController, viewModel: MainViewModel)
{

    //Create a state for the lazy column
    var state = rememberLazyListState()
    val context = LocalContext.current

    //Create our lazy column
    LazyColumn(state = state, modifier = Modifier.fillMaxSize()){

        items(viewModel.selectedDate.value.reservation_times.size) {

            if (!viewModel.selectedDate.value.reservation_times[it].bReserved) {
                //Create our rows in the column
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable {

                        //When clicked, change screen

                        //Set the selected Time in the viewModel
                        viewModel.selectedTime =
                            viewModel.selectedDate.value.reservation_times[it].hour

                        //Reserve the time
                        viewModel.selectedDate.value.reservation_times[it].bReserved = true

                        //Add the reservation ot the correct user reservation slot
                        if (viewModel.selectedMachine is Washer) {
                            viewModel.user?.reservedWasher = ReservedSlot(
                                LocalDateTime.of(
                                    viewModel.selectedDate.value.Date,
                                    viewModel.selectedTime),
                                viewModel.selectedMachine)

                        } else {
                            viewModel.user?.reservedDryer =ReservedSlot(
                                LocalDateTime.of(
                                    viewModel.selectedDate.value.Date,
                                    viewModel.selectedTime),
                                viewModel.selectedMachine)

                        }
                        viewModel.saveMachines()
                        writeToFile(context,viewModel.user!!)

                        navController.navigate(Screen.ReservationSuccessful.route)

                    }) {

                    //Display the time
                    Text(
                        text = viewModel.selectedDate.value.reservation_times[it].hour.format(
                            DateTimeFormatter.ofPattern("hh:mm a")),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .fillMaxHeight(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )

                    //Add a bar to divide
                    Divider(color = Color.Gray)
                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewReservationTime()
{
    //ReservationTimeScreen(navController = rememberNavController())
}
