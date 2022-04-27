package com.revature.laundr_o_matic.ui.theme


import android.content.Context
import android.util.Log
import androidx.compose.material.contentColorFor
import com.revature.laundr_o_matic.User
import com.revature.laundr_o_matic.model.MachineManager
import com.revature.laundr_o_matic.utility.Constants
import java.io.*

fun writeMachines(context: Context,machines:MachineManager){

    var filePath = "${ context.filesDir.toString()}"+Constants.FILEPATH_MACHINES
    val fileExists = File(filePath)
    if (!fileExists.exists()){
        fileExists.createNewFile()
    }

    val file = FileOutputStream(filePath)
    val outStream = ObjectOutputStream(file)

    outStream.writeObject(machines)
    outStream.close()
    file.close()
}

fun readMachines(context: Context,filePath: String):MachineManager{

    var absPath = "${ context.filesDir.toString()}"+filePath

    if (!File(absPath).exists()){
        val machines = MachineManager()
        writeMachines(context,machines)
        return machines
    }

    val file = FileInputStream(absPath)
    val inStream = ObjectInputStream(file)
    val machines = inStream.readObject() as MachineManager

    inStream.close()
    file.close()
    return machines
}

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

