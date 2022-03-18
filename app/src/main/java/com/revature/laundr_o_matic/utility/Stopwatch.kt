package com.revature.laundr_o_matic.utility

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.laundr_o_matic.R
import kotlinx.coroutines.delay


@Composable
fun Timer(totalTimeInSeconds: Int, initialProgress: Float) {
    var context = LocalContext.current

    var progress by remember {
        mutableStateOf(initialProgress)
    }
    var timeElapsed by remember {
        mutableStateOf(totalTimeInSeconds)
    }
    var timeRemaining by remember {       //variable for the current time
        mutableStateOf(totalTimeInSeconds)
    }
    var isTimerRunning by remember {    //variable for isTimerRunning
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = timeRemaining, key2 = isTimerRunning) {
        if (timeRemaining > 0 && isTimerRunning) {
            delay(1000L)
            timeRemaining -= 1
            timeElapsed = totalTimeInSeconds - timeRemaining
            progress = (initialProgress + timeElapsed) / totalTimeInSeconds
        }
    }
    val timeMinutes = (timeRemaining / 60)
    val timeSeconds = (timeRemaining % 60)




    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(5.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(30.dp))
                .padding(10.dp)
        ) {
            val timeDisplay = if (timeMinutes < 10 && timeSeconds < 10) {
                "0$timeMinutes:0$timeSeconds"
            } else if (timeMinutes < 10) {
                "0$timeMinutes:$timeSeconds"
            } else if (timeSeconds < 10) {
                "$timeMinutes:0$timeSeconds"
            } else "$timeMinutes:$timeSeconds"

            Text(
                text = (timeDisplay),
                fontSize = 44.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            if (!isTimerRunning) {
                Button(     //Button to stop and start the timer
                    onClick = { isTimerRunning = true },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen))
                ) {
                    Text(
                        text = "Start"
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp),
                backgroundColor = Color.LightGray,
                color = colorResource(id = R.color.customDarkBrown)
            )
            val percentCompleted = (progress * 100).toInt()
            Text(text = "$percentCompleted% complete.")
        }
    }
}
@Preview
@Composable
fun PreviewTimer() {
    Timer(3000,0f)
}