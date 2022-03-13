package com.revature.laundr_o_matic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

class MissedReservation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaundromaticTheme {
                MissedReservationScreen()
            }
        }
    }
}

@Preview
@Composable
fun MissedReservationScreen() {

    Column {

        TopAppBar(title = { Text("Missed Reservation") })

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = TopCenter) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
                contentAlignment = TopCenter
            ) {
              Image(
                    painter = painterResource(id = R.drawable.frowning_face),
                    contentDescription = "frowning face",
                    modifier = Modifier.size(250.dp)
                )
            }
            Column(
                horizontalAlignment = CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Spacer(modifier = Modifier.height(200.dp))

                Text(text = "Oh no!",
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 50.sp)
                Text(text = "You missed your reservation.",
                    fontSize = 25.sp)
                Text(text = "Would you like to reschedule?",
                    fontSize = 25.sp)

                Column(
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.60f)
                        .clip(RoundedCornerShape(30.dp))
                        .padding(10.dp)
                ) {
                    Button(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text("Reschedule")
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









