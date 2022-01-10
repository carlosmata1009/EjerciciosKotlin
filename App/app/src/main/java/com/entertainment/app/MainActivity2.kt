package com.entertainment.app

import android.app.ActionBar
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.MediaController
import android.widget.VideoView
import com.entertainment.app.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button = findViewById<Button>(R.id.button)


        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val videoView: VideoView=findViewById(R.id.videoView)
        val mediaController=MediaController(this)
        mediaController.setAnchorView(videoView)
        val lp: FrameLayout.LayoutParams = FrameLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT)
        lp.gravity = Gravity.BOTTOM
        mediaController.layoutParams = lp

        (mediaController.parent as ViewGroup).removeView(mediaController)
        val uri=Uri.parse("android.resource://"+packageName+"/"+ R.raw.american)
        videoView.setVideoURI(uri)
        videoView.start()
        videoView.setMediaController(mediaController)
        mediaController.setMediaPlayer(videoView)
        /**/
    }
}