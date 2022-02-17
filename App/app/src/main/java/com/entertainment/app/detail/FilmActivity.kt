package com.entertainment.app.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.entertainment.app.DebugLog
import com.entertainment.app.databinding.FilmOverviewBinding
import dagger.hilt.android.AndroidEntryPoint
import es.programacionmultimedia.detail.FilmViewModel
import javax.inject.Inject

@AndroidEntryPoint
class FilmActivity : AppCompatActivity() {

    companion object {
        const val FILM_ID = "ID"
    }
    @Inject
    lateinit var logger: DebugLog

    private lateinit var binding: FilmOverviewBinding

    private val viewModel: FilmViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        logger.log("Creating Activity")

        binding = FilmOverviewBinding.inflate(layoutInflater)



        setContentView(binding.root)

        val id = intent?.extras?.getInt(FILM_ID)?: 512195

        viewModel.loadFilm(id)

        viewModel.film.observe(this) {
            title=it.title
            if(it.videoId == null) {
                binding.button9.visibility = View.GONE
            } else {
                binding.button9.visibility = View.VISIBLE
                binding.button9.setOnClickListener { _->
                    launchYoutube(it.videoId)
                }
            }


        }

    }

    fun launchYoutube(id: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=$id"))
        startActivity(intent)
    }
}