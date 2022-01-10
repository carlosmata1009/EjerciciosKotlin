package com.entertainment.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.entertainment.app.databinding.ActivityMainBinding
import com.entertainment.domain.GetFilmUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var log:MyLogActivity
    @Inject
    lateinit var useCase:GetFilmUseCase
    private  lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        binding.imageView5.setImageResource(R.drawable._509356385_american_gangster)
        binding.textView2.setText("Popular on netflix")

        setContentView(binding.root)
        log.log("onCreate")
        val film = useCase.run()
        log.log(film.title)
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