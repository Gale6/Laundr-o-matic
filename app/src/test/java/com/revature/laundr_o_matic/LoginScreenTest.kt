package com.revature.laundr_o_matic

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.revature.laundr_o_matic.viewmodel.MainViewModel
import org.junit.Test
import com.revature.laundr_o_matic.LogInScreen
import com.revature.laundr_o_matic.ui.theme.writeToFile
import junit.framework.Assert.assertEquals
import org.junit.runner.manipulation.Ordering

class LoginScreenTest()
{
    @Test
    @Composable
    fun loginCredentials_isCorrect()
    {
        val context = LocalContext.current
        val initUser = User("user", "pass")
        writeToFile(context, initUser)

        assertEquals(
            "Login successful",
            initUser.equals(writeToFile(context, user = User("user", "pass")))
        )
    }
}
