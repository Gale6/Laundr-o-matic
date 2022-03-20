package com.revature.laundr_o_matic

import org.junit.Assert.*
import org.junit.Test

class RegistrationScreenKtTest{
    @Test
    fun passwordVisibilityDefaultFalse_isCorrect(){
        var passwordVisibility =false
        passwordVisibility = !passwordVisibility
        assertEquals(true,passwordVisibility)

    }

    @Test
    fun passwordVisibilityDefaultTure_isCorrect(){
        var passwordVisibility =true
        passwordVisibility = !passwordVisibility
        assertEquals(false,passwordVisibility)

    }
}