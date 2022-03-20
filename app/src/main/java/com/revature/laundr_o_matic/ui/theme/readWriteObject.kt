package com.revature.laundr_o_matic.ui.theme


import android.content.Context
import android.util.Log
import com.revature.laundr_o_matic.User
import java.io.*

fun writeToFile(context:Context,user: User){
    var filePath = "${context.getFilesDir().toString()}/${user.username}.ser"
    val fileExist =  File(filePath)
    if (!fileExist.exists())
    {
        fileExist.createNewFile()
    }
    val file = FileOutputStream(filePath)

    val outStream = ObjectOutputStream(file)

    // Method for serialization of object
    outStream.writeObject(user)

    outStream.close()
    file.close()
}

fun readFromFile(filePath: String):User{
    val file = FileInputStream(filePath)
    val inStream = ObjectInputStream(file)

    // Method for deserialization of object
    val myAccount = inStream.readObject() as User

    inStream.close()
    file.close()
    return myAccount
}

