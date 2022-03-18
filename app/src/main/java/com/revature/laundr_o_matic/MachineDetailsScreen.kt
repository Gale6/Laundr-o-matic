package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

@Composable
fun MachineDetailsScreen(navController: NavController)
{
    var context = LocalContext.current

    Column(
        Modifier.background(
            color = colorResource(id = R.color.lightCream)
        )
    )
    {
        TopAppBar(
            title =
            { Text("Machine Details", color = colorResource(id = R.color.customDarkBrown)) },
            backgroundColor = colorResource(id = R.color.animalCrossingGreen)
        )

        Column(Modifier.fillMaxSize()) {


            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(id = R.drawable.washer),
                contentDescription = "Machine Image",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .border(
                        5.dp,
                        color = colorResource(id = R.color.customDarkBrown),
                        RoundedCornerShape(5.dp)
                    )
                    .size(width = 300.dp, height = 200.dp)
                    .align(Alignment.CenterHorizontally)
            )
            {

                Spacer(Modifier.size(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 10.dp
                        )
                )
                {

                    Text(
                        text = "Machine: ",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                    Text(
                        text = "Washer 1",
                        fontSize = 25.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                }
                Spacer(Modifier.size(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                )
                {

                    Text(
                        text = "Size: ",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                    Text(
                        text = "20 loads",
                        fontSize = 25.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                }
                Spacer(Modifier.size(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
                {

                    Text(
                        text = "Price: ",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                    Text(
                        text = "$5.00",
                        fontSize = 25.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                }
                Spacer(Modifier.size(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                )
                {

                    Text(
                        text = "Time: ",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                    Text(
                        text = "50 min",
                        fontSize = 25.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        color = colorResource(id = R.color.customDarkBrown)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }

            }
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                onClick =
                { navController.navigate(Screen.ReservationSuccessful.route) },
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(60.dp)
                    .align(Alignment.CenterHorizontally)
            )
            {
                Text(
                    "Reserve",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.customDarkBrown),
                    fontSize = 30.sp,
                )
            }

        }

    }
}
@Preview
@Composable
fun PreviewMachineDetails()
{
    MachineDetailsScreen(navController = rememberNavController())
}