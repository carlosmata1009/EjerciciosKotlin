package com.entertainment.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
class MainActivity2 : AppCompatActivity() {
    private var videoPlayer:VideoView?=null
    private var videoController:MediaController?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)s
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        videoPlayer=findViewById<VideoView>(R.id.videoView)
        configVideoPlayer()
    }
    private fun configVideoPlayer(){
        if(videoPlayer==null){
            videoController= MediaController(this)
            videoController!!.setAnchorView(this.videoPlayer)
        }
        videoPlayer!!.setMediaController(videoController)
        videoPlayer!!.setVideoURI(
            Uri.parse(    "android.resource://$packageName/${R.raw.american}")
        )
        videoPlayer!!.requestFocus()
        videoPlayer!!.pause()
        videoPlayer!!.setOnErrorListener{
            _, _,_ ->
            Toast.makeText(applicationContext,"Getting error",Toast.LENGTH_SHORT).show()
            false
        }
        videoPlayer!!.setOnCompletionListener {
            Toast.makeText(applicationContext,"video completed",Toast.LENGTH_SHORT).show()
        }
    }


}