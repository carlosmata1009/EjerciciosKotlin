package com.entertainment.app

import android.util.Log
import javax.inject.Inject

class MyLogActivity @Inject constructor(){
    fun log(message:String){
        Log.d("Carlos Mata",message)
    }
}