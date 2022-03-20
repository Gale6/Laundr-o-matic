package com.revature.laundr_o_matic

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

@Composable
fun WalletScreen(navController: NavController)
{

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    )
    {
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Balance: ", fontWeight = FontWeight.Bold, fontSize = 40.sp, color = colorResource(id = R.color.customDarkBrown))
        Text(text = "$500.00 ",fontSize = 30.sp, color = colorResource(id = R.color.customDarkBrown))

        Spacer(modifier = Modifier.height(40.dp))

        Box(
            Modifier
                .border(1.dp, color = colorResource(id = R.color.tealGreen))
                .size(300.dp)
        , contentAlignment = Alignment.Center
        )
        {
            Column(Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = "Washer 2: -$ 5.00 ", Modifier.padding(5.dp), color = colorResource(id = R.color.customDarkBrown))
                Text(text = "Dryer 4: -$ 4.00 ", Modifier.padding(5.dp), color = colorResource(id = R.color.customDarkBrown))
                Text(text = "Washer 3: -$ 5.00 ", Modifier.padding(5.dp), color = colorResource(id = R.color.customDarkBrown))
                Text(text = "Washer 5: -$ 5.00 ", Modifier.padding(5.dp), color = colorResource(id = R.color.customDarkBrown))
                Text(text = "Dryer 7: -$ 5.00 ", Modifier.padding(5.dp), color = colorResource(id = R.color.customDarkBrown))
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
            modifier = Modifier.padding(10.dp),
            onClick = {/*todo*/})
        {
            Text(text = "Add funds", color = colorResource(id = R.color.customDarkBrown), fontSize = 30.sp)
        }

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.tealGreen)),
            modifier = Modifier.padding(10.dp),
            onClick = { navController.navigate(Screen.MainMenu.route)})
        {
            Text(text = "Back to Main", color = colorResource(id = R.color.customDarkBrown), fontSize = 30.sp)
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