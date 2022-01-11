package com.entertainment.app

import androidx.lifecycle.*
import com.entertainment.domain.Film
import com.entertainment.domain.GetFilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetFilmUseCase
    ):ViewModel(),LifecycleObserver {
    private val filmLiveData = MutableLiveData<Film>()
    val film:LiveData<Film> = filmLiveData
    fun loadFilm(){
        val loadedFilm=useCase.execute()
        filmLiveData.value=loadedFilm
    }
}