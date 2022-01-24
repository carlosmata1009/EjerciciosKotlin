package com.entertainment.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.entertainment.app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var log:MyLogActivity
    private  lateinit var binding:ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        viewModel.loadFilm()
        viewModel.film.observe(this){
            binding.imageView5.setImageResource(R.drawable._509356385_american_gangster)
            binding.textView4.text = it.title
            Glide.with(this).load(it.imageUrl).into(binding.imageView5)
        }

        setContentView(binding.root)
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