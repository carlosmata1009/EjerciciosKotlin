package com.entertainment.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()//Delete bar
        val button = findViewById<Button>(R.id.button5)
        button.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
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