package com.entertainment.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var log:MyLogActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log.log("onCreate")
        supportActionBar?.hide()//Delete bar
        val button = findViewById<Button>(R.id.button5)
        button.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
    override fun onResume(){
        super.onResume()
        log.log("onResume")
    }
    override fun onPause(){
        super.onPause()
        log.log("onPause")
    }
    override fun onDestroy(){
        super.onDestroy()
        log.log("onDestroy")
    }
}