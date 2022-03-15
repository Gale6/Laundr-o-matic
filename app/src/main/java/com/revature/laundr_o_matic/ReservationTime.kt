package com.revature.laundr_o_matic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ReservationTimeScreen(navController: NavController)
{
    val sdf = SimpleDateFormat("dd/M")
    val currentDate = sdf.format(Date())
    var selectedDate = remember { mutableStateOf(currentDate) }

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        TopAppBar(title = { Text("Reservation Time") })
        selectedDate = dateSelection(select = selectedDate)
        Box(modifier=Modifier.fillMaxWidth())
        {
            Text(
                "Selected Date: \t${selectedDate.value}", modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color.Black, RoundedCornerShape(5.dp)), fontSize = 30.sp, textAlign = TextAlign.Center
            )
        }
        TimeList(time = selectedDate)

    }

}
@Composable
fun dateSelection( select: MutableState<String>): MutableState<String>
{
    val MILLIS_IN_A_DAY:Long = 1000 * 60 * 60 * 24;

    val sdf = SimpleDateFormat("dd/M")
    val currentDate = Date()
    var dateRange = ArrayList<String>()
    var selectedDate = select

    for(i in 0..3){
        var displayDate = sdf.format((currentDate.time+(MILLIS_IN_A_DAY*i)))
        dateRange.add(displayDate)
    }

    Row(modifier = Modifier
        .padding(10.dp)){
        for(item in dateRange)
        {
            Button(onClick = {
                selectedDate.value = item
            },
                modifier = Modifier.padding(10.dp),){
                Text(item)
            }

        }

    }
    return selectedDate

}
@Composable
fun TimeList(time: MutableState<String>)
{
    var availableTimes = ArrayList<String>()

    availableTimes.add("6:00 am")
    availableTimes.add("7:00 am")
    availableTimes.add("8:00 am")
    availableTimes.add("9:00 am")
    availableTimes.add("10:00 am")
    availableTimes.add("11:00 am")
    availableTimes.add("12:00 pm")
    availableTimes.add("1:00 pm")
    availableTimes.add("2:00 pm")
    availableTimes.add("3:00 pm")
    availableTimes.add("4:00 pm")
    availableTimes.add("5:00 pm")
    availableTimes.add("6:00 pm")
    availableTimes.add("7:00 pm")
    availableTimes.add("8:00 pm")
    availableTimes.add("9:00 pm")

    var ctx = LocalContext.current
    var state = rememberLazyListState()
    LazyColumn(state = state, modifier = Modifier.fillMaxSize()){
        items(availableTimes.size){
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clickable {
                    onTimeClick(ctx)
                }) {

                Text(text = availableTimes[it],
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .fillMaxHeight(),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center)
            }
            Divider(color = Color.Gray)
        }
    }
}
fun onTimeClick(ctx: Context){
    ctx.startActivity(Intent(ctx,ReservationSuccessful::class.java))
}

@Preview
@Composable
fun PreviewReservationTime()
{
    ReservationTimeScreen()
}
