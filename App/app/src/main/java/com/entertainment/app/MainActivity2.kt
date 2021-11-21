package com.entertainment.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            var videoView: VideoView=findViewById(R.id.videoView)
            val mediaController=MediaController(this)
            mediaController.setAnchorView(videoView)
            videoView.setVideoPath("https://youtu.be/y8x3I0Ndt_E")
            videoView.start()
            videoView.setMediaController(mediaController)
        }
    }
}