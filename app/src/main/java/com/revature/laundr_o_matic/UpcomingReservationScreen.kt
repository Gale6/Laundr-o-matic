package com.revature.laundr_o_matic

import android.content.Intent
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

@Composable
fun UpcomingReservationScreen(navController: NavController) {
    val context = LocalContext.current

    Column {

        TopAppBar(title = { Text("Upcoming Reservation") })

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.washing_machine),
                    contentDescription = "Machine icon",
                    modifier = Modifier.size(250.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Spacer(modifier = Modifier.height(250.dp))


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.60f)
                        .clip(RoundedCornerShape(30.dp))
                        .padding(10.dp)
                ) {
                    Text(text = "Size: 20 loads",
                        fontSize = 25.sp,)
                    Text(text = "Price: $5.00",
                        fontSize = 25.sp)
                    Text(text = "Cycle Time: 50 min",
                        fontSize = 25.sp)

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = { /*TODO cancels current reservation*/ }, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text("Cancel Reservation")
                    }
                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(onClick = {navController.navigate(Screen.MainMenu.route)}, modifier = Modifier
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

@Preview(showBackground = true)
@Composable
fun UpcomingReservationScreenPreview() {
    LaundromaticTheme {
        UpcomingReservationScreen(navController = rememberNavController())
    }
}