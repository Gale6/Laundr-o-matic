package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

@Composable
fun MachinesInUseScreen(navController: NavController)
{
    val context = LocalContext.current

    Column {

        TopAppBar(
            title = { Text("Machines in use", color = colorResource(id = R.color.customDarkBrown)) },
            backgroundColor = colorResource(id = R.color.animalCrossingGreen))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.lightCream)),
            contentAlignment = TopCenter,
        )
        {
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = TopCenter
            )
            {
                Column(
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
                {
                    Spacer(modifier = Modifier.height(100.dp))

                    Text(
                        text = "Your Machines",
                        fontWeight = FontWeight.Bold,
                        fontSize = 50.sp,
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                    Text(
                        text = "Currently Running:",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Column(
                        horizontalAlignment = CenterHorizontally,
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.80f)
                            .clip(RoundedCornerShape(30.dp))
                            .padding(horizontal = 5.dp, vertical = 5.dp)
                    )
                    {
                        Button( colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                            onClick =
                            { navController.navigate(Screen.CurrentMachine.route)},
                            modifier = Modifier
                                .width(320.dp)
                                .height(55.dp)
                        )
                        {
                            Text(
                                text = "Washer 1: Time Left: 20 min",
                                color = colorResource(id = R.color.customDarkBrown),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp
                            )
                        }

                        Spacer(modifier = Modifier.padding(10.dp))

                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                            onClick = { navController.navigate(Screen.CurrentMachine.route)},
                            modifier = Modifier
                                .width(320.dp)
                                .height(50.dp)
                        )
                        {
                            Text(
                                text = "Drier 1: Time Left: 40 min",
                                color = colorResource(id = R.color.customDarkBrown),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp
                            )
                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                        Text(
                            text = "Reservations:",
                            fontSize = 25.sp,
                            color = colorResource(id = R.color.customDarkBrown),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.padding(20.dp))

                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                            onClick =
                            {navController.navigate(Screen.UpcomingReservation.route)},
                            modifier = Modifier
                                .width(320.dp)
                                .height(50.dp)
                        )
                        {
                            Text(text = "Washer 2: 10:00 on 03/22/22",
                                color = colorResource(id = R.color.customDarkBrown),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp
                            )
                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                        Button( colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                            onClick =
                            {navController.navigate(Screen.UpcomingReservation.route)},
                            modifier = Modifier
                                .width(320.dp)
                                .height(50.dp)
                        )
                        {
                            Text(text = "Drier 2: 11:00 on 03/22/22",
                                color = colorResource(id = R.color.customDarkBrown),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = "Exit:",
                            fontSize = 25.sp,
                            color = colorResource(id = R.color.customDarkBrown),
                            textAlign = TextAlign.Center
                        )
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                            onClick =
                            {navController.navigate(Screen.MainMenu.route)},
                            modifier = Modifier
                                .width(320.dp)
                                .height(50.dp)
                        )
                        {
                            Text("Main Menu",
                                color = colorResource(id = R.color.customDarkBrown),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MachinesInUseScreenPreview() {
    LaundromaticTheme {
        MachinesInUseScreen(navController = rememberNavController())
    }
}