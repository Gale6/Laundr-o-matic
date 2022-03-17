package com.revature.laundr_o_matic

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.model.DateSlot
import com.revature.laundr_o_matic.model.ReservationManager

@Composable
fun ReservationTimeScreen(navController: NavController)
{
    //temporary create Reservation Manager, should come from ViewModel
    val reservationMng = ReservationManager()

    //Create a temp variable to hold our current selected date
    var selectedDate:MutableState<DateSlot> = remember { mutableStateOf(reservationMng.mDays[0]) }

    //Column to start our screen
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        //Top bar of screen
        TopAppBar(title = { Text("Reservation Time") })

        //Call our function that creates the Date Buttons
        selectedDate = dateSelection(select = selectedDate, reservationMng)

        //Display the currently selected date
        Box(modifier=Modifier.fillMaxWidth())
        {
            Text(
                "Selected Date: \t${selectedDate.value.sDate}", modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color.Black, RoundedCornerShape(5.dp)), fontSize = 30.sp, textAlign = TextAlign.Center
            )
        }
        //Display our LazyColumn of times for the selected date
        TimeList(navController,selectedDate)

    }

}
@Composable
fun dateSelection( select: MutableState<DateSlot>, reservationMng:ReservationManager): MutableState<DateSlot>
{
    //Store our passed in date for use
    var selectedDate = select

    //Row for the Different Date Buttons
    Row(modifier = Modifier
        .padding(10.dp)){

        //for each day our reservation manager holds
        for(item in reservationMng.mDays)
        {

            //Button for the day
            Button(onClick = {

                //On clicking a button, change our selected date to the new date
                selectedDate.value = item
            },
                modifier = Modifier.padding(10.dp),){

                //Display the date in the button
                Text(item.sDate)
            }

        }

    }
    //Return our new date
    return selectedDate

}
@Composable
fun TimeList(navController : NavController, date : MutableState<DateSlot>)
{

    //Create a state for the lazy column
    var state = rememberLazyListState()

    //Create our lazy column
    LazyColumn(state = state, modifier = Modifier.fillMaxSize()){

        items(date.value.getHours().size){

            //Create our rows in the column
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clickable {

                    //When clicked, change screen
                    navController.navigate(Screen.ReservationSuccessful.route)

                }) {

                //Display the time
                Text(text = date.value.getHour(it+1).sHour,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .fillMaxHeight(),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center)

                //Add a bar to divide
                Divider(color = Color.Gray)
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
