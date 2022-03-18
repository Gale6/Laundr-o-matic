package com.revature.laundr_o_matic

import android.content.Intent
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Normal
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

@Composable
fun CurrentMachineScreen(navController: NavController)
{
    val context = LocalContext.current

    Column {

        TopAppBar(
            title = { Text("Current Machine", color = colorResource(id = R.color.customDarkBrown)) },
            backgroundColor = colorResource(id = R.color.animalCrossingGreen)
        )

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter)
        {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.lightCream)),
                contentAlignment = Alignment.TopCenter
            )
            {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
                {
                    Text(
                        text = "Progress",
                        fontSize = 50.sp,
                        color = colorResource(id = R.color.customDarkBrown),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Your clothes are currently \nwashing.",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "They are...",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.customDarkBrown),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.washing_machine),
                        contentDescription = "Washer Icon",
                        Modifier.size(250.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "50% Complete",
                        fontSize = 50.sp,
                        color = colorResource(id = R.color.customDarkBrown),
                        fontWeight = Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "You will be notified five minutes\n before your cycle ends.",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.customDarkBrown),
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(onClick =
                    { navController.navigate(route = Screen.MainMenu.route)},
                        modifier = Modifier
                            .height(60.dp)
                            .width(200.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.tealGreen))
                    )
                    {
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
}

@Preview (showBackground = true)
@Composable
fun CurrentMachineScreenPreview()
{
    LaundromaticTheme()
    {
        CurrentMachineScreen(navController = rememberNavController())
    }
}