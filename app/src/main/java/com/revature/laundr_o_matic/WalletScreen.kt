package com.revature.laundr_o_matic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

@Composable
fun WalletScreen(navController: NavController)
{
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.lightCream))
            .background(color = colorResource(id = R.color.lightCream))
    )
    {
        Spacer(modifier = Modifier.height(100.dp))

        Text(text = "Balance: ", fontWeight = FontWeight.Bold, fontSize = 40.sp, color = colorResource(id = R.color.customDarkBrown))
        Text(text = "$500.00 ",fontSize = 30.sp, color = colorResource(id = R.color.customDarkBrown))

        Spacer(modifier = Modifier.height(40.dp))

        Box(
            Modifier
                .border(5.dp, color = colorResource(id = R.color.tealGreen))
                .width(250.dp).height(200.dp), contentAlignment = Alignment.Center
        )
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(
                    text = "Washer 2: -$ 5.00 ",
                    Modifier.padding(5.dp),
                    color = colorResource(id = R.color.customDarkBrown),
                    fontSize = 20.sp
                )
                Text(
                    text = "Dryer 4: -$ 4.00 ",
                    Modifier.padding(5.dp),
                    color = colorResource(id = R.color.customDarkBrown),
                    fontSize = 20.sp
                )
                Text(
                    text = "Washer 3: -$ 5.00 ",
                    Modifier.padding(5.dp),
                    color = colorResource(id = R.color.customDarkBrown),
                    fontSize = 20.sp
                )
                Text(
                    text = "Washer 5: -$ 5.00 ",
                    Modifier.padding(5.dp),
                    color = colorResource(id = R.color.customDarkBrown),
                    fontSize = 20.sp
                )
                Text(
                    text = "Dryer 7: -$ 5.00 ",
                    Modifier.padding(5.dp),
                    color = colorResource(id = R.color.customDarkBrown),
                    fontSize = 20.sp
                )
            }

        }

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
            onClick = {/*todo*/}
        )
        {
            Text(text = "Add funds", color = colorResource(id = R.color.customDarkBrown), fontSize = 30.sp, textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
            onClick = { navController.navigate(Screen.MainMenu.route)}
        )
        {
            Text(text = "Back to Main", color = colorResource(id = R.color.customDarkBrown), fontSize = 30.sp, textAlign = TextAlign.Center)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3()
{
    LaundromaticTheme()
    {
        WalletScreen(navController = rememberNavController())
    }
}