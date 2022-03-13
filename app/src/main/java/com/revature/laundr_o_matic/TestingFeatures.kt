package com.revature.laundr_o_matic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class TestingFeatures : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChangeFont()
        }
    }
}

@Composable
fun ChangeFont()
{
//    val context = LocalContext.Current
//    Typeface typeface = ResourcesCompat.getFont(context, R.font.myfont);
//    textView.setTypeface(typeface);
}

@Preview
@Composable
fun PreviewChangeFont()
{
    ChangeFont()
}