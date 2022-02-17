package com.entertainment.app.detail

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.entertainment.app.FilmLauncher
import com.entertainment.app.R
import com.entertainment.app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity(),FilmLauncher {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
    override fun openDetails(id: Int) {
        val fragment = FilmFragment()
        fragment.arguments = Bundle().apply {
            putInt(FilmFragment.FILM_ID, id)
        }

        val isTablet = resources.getBoolean(R.bool.isTablet)

        if (isTablet) {
            supportFragmentManager.beginTransaction()
                .add(R.id.detail, fragment).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.list, fragment)
                .addToBackStack("BACKSTACK")
                .commit()
        }

    }
}