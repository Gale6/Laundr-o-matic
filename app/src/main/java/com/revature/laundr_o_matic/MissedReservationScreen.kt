package com.revature.laundr_o_matic

import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

@Composable
fun MissedReservationScreen(navController: NavController)
{

    LocalContext.current
    Column (
        modifier = Modifier
            .background(color = colorResource(id = R.color.lightCream)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    )
    {

        TopAppBar(title =
        {
            Text(
                "Missed Reservation",
                color = colorResource(id = R.color.customDarkBrown))
        },
            backgroundColor = colorResource(id = R.color.animalCrossingGreen)
        )

        Spacer(modifier = Modifier.height(40.dp))
        
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = TopCenter) {
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = TopCenter
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.grey_sad_face_icon_2),
                    contentDescription = "Sad face",
                    modifier = Modifier.size(180.dp)
                )
            }
            Column(
                horizontalAlignment = CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

                Spacer(modifier = Modifier.height(160.dp))

                Text(
                    text = "Oh no!",
                    style =
                    TextStyle
                        (fontWeight = FontWeight.Bold),
                    fontSize = 50.sp,
                    color = colorResource(id = R.color.animalCrossingGreen)
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "You missed your reservation." +
                            "\nWould you like to reschedule?",
                    fontSize = 25.sp,
                    color = colorResource(id = R.color.brownGrey)
                )

                Spacer(modifier = Modifier.height(20.dp))


                Column(
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.60f)
                        .clip(RoundedCornerShape(30.dp))
                        .padding(10.dp)
                )
                {
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                        onClick = {navController.navigate(Screen.MachineReservation.route)},
                        modifier = Modifier
                            .width(200.dp)
                            .height(50.dp)

                    )
                    {
                        Text(
                            "Reschedule",
                            color = colorResource(id = R.color.customDarkBrown),
                            fontSize = 25.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
                        onClick = {navController.navigate(Screen.MainMenu.route)},
                        modifier = Modifier
                            .height(50.dp)
                            .width(170.dp)
                    )
                    {
                        Text(
                            "Main Menu",
                            color = colorResource(id = R.color.customDarkBrown),
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MissedReservationPreview() {
    LaundromaticTheme {
        MissedReservationScreen(navController = rememberNavController())
    }
}