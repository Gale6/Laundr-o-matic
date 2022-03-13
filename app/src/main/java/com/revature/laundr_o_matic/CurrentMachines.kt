package com.revature.laundr_o_matic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

class CurrentMachines : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaundromaticTheme {
                CurrentMachinesScreen()
            }
        }
    }
}

@Preview
@Composable
fun CurrentMachinesScreen() {

    Column {

        TopAppBar(title = { Text("Current Machines") })

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = TopCenter) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
                contentAlignment = TopCenter) {
                Column(
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Spacer(modifier = Modifier.height(100.dp))

                    Text(
                        text = "Your Machines",
                        style = TextStyle(color = Color.Green),
                        fontWeight = FontWeight.Bold,
                        fontSize = 50.sp
                    )
                    Text(
                        text = "Currently Running:",
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Column(
                        horizontalAlignment = CenterHorizontally,
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.80f)
                            .clip(RoundedCornerShape(30.dp))
                            .padding(10.dp)
                    ) {
                        Button(onClick = {/* TODO: Takes you to current washer in use*/}, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                        ) {
                            Text(text = "Washer 1: Time Left: 20 min")
                        }

                        Spacer(modifier = Modifier.padding(10.dp))

                        Button(onClick = {/* TODO: Takes you to current drier in use */}, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                        ) {
                            Text(text = "Drier 1: Time Left: 40 min")
                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                        Text(
                            text = "Reservations:",
                            fontSize = 25.sp
                        )

                        Spacer(modifier = Modifier.padding(10.dp))

                        Button(onClick = {/* TODO: Takes you to current washer reservation*/}, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                        ) {
                            Text(text = "Washer 2: 10:00 on 03/22/22")
                        }

                        Spacer(modifier = Modifier.padding(10.dp))

                        Button(onClick = {/* TODO: Takes you to current drier reservation*/}, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                        ) {
                            Text(text = "Drier 2: 11:00 03/22/22")
                        }
                        Spacer(modifier = Modifier.padding(10.dp))

                        Button(onClick = { /* TODO goes back to main menu*/ }, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                        ) {
                            Text("Main Menu")
                        }
                    }
                }
            }
        }
    }
}
