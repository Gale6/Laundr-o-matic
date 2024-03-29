package com.revature.laundr_o_matic

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme
import com.revature.laundr_o_matic.utility.Timer

@Composable
fun CurrentMachineScreen(navController: NavController)
{

    Column {

        TopAppBar(
            title = { Text("Current Machine", color = colorResource(id = R.color.customDarkBrown)) },
            backgroundColor = colorResource(id = R.color.animalCrossingGreen)
        )
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter)
        {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {

                    Text(
                        text = "Progress",
                        fontSize = 40.sp,
                        color = colorResource(id = R.color.customDarkBrown),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text(
                        text = "Your clothes are currently \ncycling.",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Timer(3000, 0f)

                    Text(
                        text = "You will be notified five minutes\n before your cycle ends.",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.customDarkBrown),
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Button(onClick =
                    { navController.navigate(route = Screen.MainMenu.route)},
                        modifier = Modifier
                            .height(60.dp)
                            .width(200.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.tealGreen))
                    ) {

                        Text("Main Menu",
                            color = colorResource(id = R.color.customDarkBrown),
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
@Preview (showBackground = true)
@Composable
fun CurrentMachineScreenPreview() {
    LaundromaticTheme {
        CurrentMachineScreen(navController = rememberNavController())
    }
}