package com.entertainment.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.graphics.drawable.DrawableCompat.inflate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmActivity : AppCompatActivity() {

    private lateinit var binding:FilmListBinding
    private val viewModel:FilmListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=FilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}