package com.entertainment.app

import android.icu.text.CaseMap
import androidx.lifecycle.*
import com.entertainment.domain.Film
import com.entertainment.domain.GetFilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetFilmUseCase
    ):ViewModel(),LifecycleObserver {
    private val filmLiveData = MutableLiveData<FilmDataView>()
    val film:LiveData<FilmDataView> = filmLiveData
    fun loadFilm(){
        val loadedFilm=useCase.execute()
        filmLiveData.value=FilmDataView(loadedFilm.title)
    }
}
data class FilmDataView(val title: String)