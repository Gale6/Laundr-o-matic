package com.revature.laundr_o_matic


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

@Composable
fun MainMenuScreen(navController: NavController)
{
    var context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .background(color = colorResource(id = R.color.lightCream))
            .background(color = colorResource(id = R.color.lightCream)))
    {


        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Main Menu",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 60.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.animalCrossingGreen)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier =
            Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        )
        {

            Column(
                modifier =
                Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {


                Spacer(modifier = Modifier.height(20.dp))

                Surface(
                    modifier = Modifier
                        .height(165.dp)
                        .width(145.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        color = colorResource(id = R.color.animalCrossingGreen)
                    )
                )
                {

                    Spacer(modifier = Modifier.height(10.dp))

                    Image(painter = painterResource(com.revature.laundr_o_matic.R.drawable.grey_reservation_icon),
                        contentDescription = "Reservation time icon",
                        modifier = Modifier
                            .clickable { navController.navigate(Screen.MachineReservation.route) }
                            .size(150.dp),
                        alignment = Alignment.BottomCenter
                    )
                    Text(
                        text = "New Reservation",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.brownGrey),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(64.dp))

                Surface(
                    modifier = Modifier
                        .height(165.dp)
                        .width(145.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        color = colorResource(id = R.color.animalCrossingGreen)
                    )
                )
                {

                    Image(painter = painterResource(com.revature.laundr_o_matic.R.drawable.grey_wallet_icon),
                        contentDescription = "Wallet icon",
                        modifier = Modifier
                            .clickable {  /*context.startActivity(Intent(context,createNewReservation::Class.java))*/ } // change to user wallet
                            .size(150.dp),
                        alignment = Alignment.BottomCenter
                    )
                    Text(
                        text = "Wallet",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.brownGrey),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Spacer(modifier = Modifier.height(15.dp))

                Surface(
                    modifier = Modifier
                        .height(165.dp)
                        .width(250.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        color = colorResource(id = R.color.animalCrossingGreen)
                    )

                )
                {

                    Image(painter = painterResource(com.revature.laundr_o_matic.R.drawable.grey_hour_glass_icon),
                        contentDescription = "Hourglass current machines icon",
                        modifier = Modifier
                            .clickable { navController.navigate(Screen.MachineInUse.route) }
                            .size(150.dp),
                        alignment = Alignment.BottomCenter
                    )

                    Text(
                        text = "Current Machines",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.brownGrey),
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(64.dp))

                Surface(
                    modifier = Modifier
                        .height(165.dp)
                        .width(250.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        color = colorResource(id = R.color.animalCrossingGreen)
                    )
                )
                {

                    Image(painter = painterResource(com.revature.laundr_o_matic.R.drawable.grey_user_icon),
                        contentDescription = "Personal info icon",
                        modifier = Modifier
                            .clickable {
                                navController.navigate(Screen.UserProfile.route)
                            }
                            .size(150.dp).padding(5.dp),
                        alignment = Alignment.BottomCenter
                    )
                    Text(
                        text = "Personal Info",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.brownGrey),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainMenu() {
    LaundromaticTheme {
        MainMenuScreen(navController = rememberNavController())
    }

}