package com.entertainment.app.list

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.entertainment.app.DebugLog
import dagger.hilt.android.AndroidEntryPoint

import javax.inject.Inject

@AndroidEntryPoint
class FilmListActivity : AppCompatActivity() {


    @Inject
    lateinit var adapter: FilmListAdapter

    @Inject
    lateinit var logger: DebugLog

    lateinit var binding: FilmListActivityBinding

    private val viewModel: FilmListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilmListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.root.adapter = adapter

        viewModel.loadFilmList()

        viewModel.filmList.observe(this) {
            adapter.submitList(it)
        }

        adapter.callback = {
            logger.log("Click en película: $")
            val filmActivityIntent = Intent(this, FilmActivity::class.java)
            filmActivityIntent.putExtra(FilmActivity.FILM_ID, it.id)
            startActivity(filmActivityIntent)
        }

    }


}