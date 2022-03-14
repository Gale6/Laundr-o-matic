package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

class CurrentMachine : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaundromaticTheme {
                CurrentMachineScreen()
            }
        }
    }
}

@Composable
fun CurrentMachineScreen() {
    val context = LocalContext.current

    Column {

        TopAppBar(title = { Text("Current Machine") })

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )  {
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Your clothes are",
                        fontSize = 25.sp
                    )
                    Text(
                        text = "currently washing.",
                        fontSize = 25.sp
                    )
                    Text(
                        text = "They are...",
                        fontSize = 25.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.frowning_face),
                        contentDescription = "Washer Icon",
                        Modifier.size(250.dp)
                        )
                    Text(
                        text = "50% Complete",
                        fontSize = 50.sp
                    )
                    Text(
                        text = "You will be notified five minutes",
                        fontSize = 25.sp
                    )
                    Text(
                        text = "before your cycle ends.",
                        fontSize = 25.sp
                    )
                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(onClick = {context.startActivity(Intent(context, MainMenuActivity::class.java))}, modifier = Modifier
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

@Preview (showBackground = true)
@Composable
fun CurrentMachineScreenPreview() {
    LaundromaticTheme() {
        CurrentMachineScreen()
    }
}