package com.revature.laundr_o_matic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme
import com.revature.laundr_o_matic.viewmodel.MainViewModel

@Composable
fun UpcomingReservationScreen(navController: NavController,viewModel:MainViewModel) {

    viewModel.update()


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(color = colorResource(id = R.color.lightCream)).background(color = colorResource(id = R.color.lightCream))
    )
    {

        TopAppBar(
            title =
            {
                Text(
                    "Upcoming Reservation",
                    color = colorResource(id = R.color.customDarkBrown)
                )
            },
            backgroundColor = colorResource(id = R.color.animalCrossingGreen)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {



                Image(
                    painter = painterResource(id = R.drawable.washing_machine),
                    contentDescription = "Machine icon",
                    modifier = Modifier.size(250.dp)
                )





                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Size: 20 loads",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                    Text(
                        text = "Price: $5.00",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                    Text(
                        text = "Cycle Time: 50 min",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown)
                    )

                    Spacer(modifier = Modifier.height(20.dp))


                    // If within 5 min, allow for starting the machine
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                        onClick = { /*TODO cancels current reservation*/ }, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(60.dp)
                    )
                    {
                        Text(
                            "Start Machine",
                            color = colorResource(id = R.color.customDarkBrown),
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center
                        )
                    }


                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                        onClick = { /*TODO cancels current reservation*/ }, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(60.dp)
                    )
                    {
                        Text(
                            "Cancel Reservation",
                            color = colorResource(id = R.color.customDarkBrown),
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                        onClick = { navController.navigate(Screen.MainMenu.route) },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(60.dp)
                    )
                    {
                        Text(
                            "Main Menu",
                            color = colorResource(id = R.color.customDarkBrown),
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }



@Preview(showBackground = true)
@Composable
fun UpcomingReservationScreenPreview() {
    LaundromaticTheme {
        UpcomingReservationScreen(navController = rememberNavController(),MainViewModel())
    }
}