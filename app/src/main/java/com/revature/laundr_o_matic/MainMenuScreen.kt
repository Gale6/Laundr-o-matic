package com.revature.laundr_o_matic

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {


        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Main Menu",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 60.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.customDarkBrown)
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

                Image(painter = painterResource(R.drawable.time_128),
                    contentDescription = "reservation time icon",
                    modifier = Modifier
                        .clickable { navController.navigate(Screen.MachineReservation.route) }
                        .size(150.dp)
                )
                Text(
                    text = "New Reservation",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.customDarkBrown),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(64.dp))
                Image(painter = painterResource(R.drawable.clipboard_8_128),
                    contentDescription = "history clipboard icon",
                    modifier = Modifier
                        .clickable { /* context.startActivity(Intent(context,createNewReservation::Class.java)) */ }
                        .size(150.dp)
                )
                Text(
                    text = "History",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.customDarkBrown),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(R.drawable.sandglass_128),
                    contentDescription = "hourglass current machines icon",
                    modifier = Modifier
                        .clickable { navController.navigate(Screen.MachineInUse.route) }
                        .size(150.dp)
                )

                Text(
                    text = "Current Machines",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.customDarkBrown),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(64.dp))
                Image(painter = painterResource(R.drawable.user_128),
                    contentDescription = "personalInfoIcon",
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.UserProfile.route)
                        }
                        .size(150.dp)
                )
                Text(
                    text = "Personal Info",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.customDarkBrown),
                    textAlign = TextAlign.Center
                )

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