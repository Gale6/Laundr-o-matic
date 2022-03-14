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
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

class MachineReservation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaundromaticTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MachineReservationScreen()
                }
            }
        }
    }
}

@Composable
fun MachineReservationScreen()
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

    val context = LocalContext.current

    Column {
        TopAppBar(title = {Text("Select a Machine")})

        var state = rememberLazyListState()
        LazyColumn(state = state){
            items(machineArray.size)
            {
                //id of the machine we are using, currently
                //only changes if the machine starts with a D
                var iMachine: Int = if (machineArray.get(it)
                        .startsWith('D')
                ) R.drawable.dryer else R.drawable.washer
                Row(modifier = Modifier.background(MaterialTheme.colors.background)
                    .clickable {

                        context.startActivity(Intent(context,MachineDetails::class.java))
                    })
                {
                    Image(
                        painter = painterResource(id = iMachine),
                        contentDescription = "Machine Icon",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(10.dp)
                    )
                    Column {
                        Text(
                            machineArray[it], modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            fontSize = 20.sp
                        )
                        Spacer(Modifier.size(10.dp))
                        Row() {
                            Text("Cost: $5.00")
                            Spacer(Modifier.size(10.dp))
                            Text("Load: 20")
                            Spacer(Modifier.size(10.dp))
                            Text("Time: 50min")
                        }
                    }

                }
                Divider(color = Color.Gray)
            }

        }


    }




}
@Preview
@Composable
fun PreviewReservation()
{
    MachineReservationScreen()
}