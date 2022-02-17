package com.entertainment.app.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.entertainment.app.DebugLog
import com.entertainment.app.FilmLauncher
import com.entertainment.app.databinding.FilmOverviewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FilmListFragment : Fragment() {

    @Inject
    lateinit var adapter: FilmListAdapter

    @Inject
    lateinit var logger: DebugLog

    private lateinit var binding: FilmOverviewBinding

    private val viewModel: FilmListViewModel by viewModels()

    private var filmLauncher: FilmLauncher? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        filmLauncher = context as? FilmLauncher
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FilmOverviewBinding.inflate(layoutInflater)


        binding.root.adapter = adapter

        val isTablet = resources.getBoolean(R.bool.isTablet)

        if (isTablet) {
            binding.root.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        } else {
            binding.root.layoutManager = GridLayoutManager(context, 2)
        }



        viewModel.loadFilmList()

        viewModel.filmList.observe(this) {
            adapter.submitList(it)
        }

        adapter.callback = {
            logger.log("Click: $")
            filmLauncher?.openDetails(it.id)
        }
        return binding.root
    }


}