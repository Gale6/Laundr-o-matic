package com.revature.laundr_o_matic


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.revature.laundr_o_matic.ui.theme.LaundromaticTheme

class MainMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaundromaticTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent()
                }
            }
        }
    }
}


@Composable
fun MainContent() {
    var context = LocalContext.current
    Row(modifier = Modifier.padding(16.dp),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center ){
        Column(modifier = Modifier.padding(16.dp),horizontalAlignment= Alignment.CenterHorizontally) {
            Image(painter = painterResource(com.revature.laundr_o_matic.R.drawable.createnewicon), contentDescription = "createNewIcon", modifier = Modifier
                .clickable { context.startActivity(Intent(context,MachineReservation::class.java)) }
                .size(150.dp)
            )
            Text(text = "New Reservation",fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(64.dp))
            Image(painter = painterResource(com.revature.laundr_o_matic.R.drawable.history1), contentDescription = "history", modifier = Modifier
                .clickable { /* context.startActivity(Intent(context,createNewReservation::Class.java)) */ }
                .size(150.dp)
            )
            Text(text = "History",fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.padding(16.dp),horizontalAlignment= Alignment.CenterHorizontally) {
            Image(painter = painterResource(com.revature.laundr_o_matic.R.drawable.hourglass), contentDescription = "hourglass", modifier = Modifier
                .clickable { context.startActivity(Intent(context, MachinesInUse::class.java)) }
                .size(150.dp)
            )
            Text(text = "Current Machines",fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(64.dp))
            Image(painter = painterResource(com.revature.laundr_o_matic.R.drawable.person1), contentDescription = "personalInfoIcon", modifier = Modifier
                .clickable {
                    context.startActivity(
                        Intent(
                            context,
                            UserProfileActivity::class.java
                        )
                    )
                }
                .size(150.dp)
            )
            Text(text = "Personal Info",fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold)

        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMainMenu() {
    LaundromaticTheme {
        MainContent()
    }

}