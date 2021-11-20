package com.entertainment.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()//Delete bar
        val button = findViewById<Button>(R.id.button5)
        button.setOnClickListener(){
            val Intent = Intent(this,MainActivity2::class.java)
            startActivity(Intent)
        }
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