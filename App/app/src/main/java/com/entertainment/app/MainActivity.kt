package com.entertainment.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("carlos","Creating app")

    }
    override fun onResume(){
        super.onResume()
        Log.d("carlos","App on resume")
    }
    override fun onPause(){
        super.onPause()
        Log.d("carlos","App paused")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("carlos","Destroying")
    }
}