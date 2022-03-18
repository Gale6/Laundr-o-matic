package com.revature.laundr_o_matic.utility

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.laundr_o_matic.R
import kotlinx.coroutines.delay


@Composable
fun Timer(totalTime: Double, initialValue: Float = 0f) {

    var progress by remember {             //variable for progress
        mutableStateOf(initialValue)
    }
    var currentTime by remember {       //variable for the current time
        mutableStateOf(totalTime)
    }
    var isTimerRunning by remember {    //variable for isTimerRunning
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if (currentTime > 0 && isTimerRunning) {
            delay(100L)
            currentTime -= 100L
            progress = (currentTime / totalTime).toFloat()
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(30.dp))
            .padding(10.dp)
    ) {
        Text(
            text = (currentTime / 1000L).toString(),
            fontSize = 44.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Button(     //Button to stop and start the timer
            onClick = {
                if (currentTime <= 0L) {
                    currentTime = totalTime
                    isTimerRunning = true
                } else {
                    isTimerRunning = !isTimerRunning
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (!isTimerRunning || currentTime <= 0L) {
                    colorResource(id = R.color.tealGreen)
                } else {
                    colorResource(id = R.color.customDarkBrown)
                }
            )
        ) {
            Text(
                text = if (isTimerRunning && currentTime >= 0) "Stop"
                else if (!isTimerRunning && currentTime >= 0L) "Start"
                else "Restart"
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        LinearProgressIndicator(
            progress = -(progress),
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp),
            backgroundColor = Color.LightGray,
            color = colorResource(id = R.color.customDarkBrown)
        )
    }
}

@Preview
@Composable
fun PreviewTimer() {
    Timer(50000.00)
}