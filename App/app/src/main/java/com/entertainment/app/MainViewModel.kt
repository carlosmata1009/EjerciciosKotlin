package com.entertainment.app

import android.icu.text.CaseMap
import androidx.lifecycle.*
import com.entertainment.domain.Film
import com.entertainment.domain.GetFilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetFilmUseCase
    ):ViewModel(),LifecycleObserver {

    private val filmLiveData = MutableLiveData<FilmDataView>()
    val film:LiveData<FilmDataView> = filmLiveData
    var job: Job? =null
    fun loadFilm(){
        //val loadedFilm=useCase.execute()
        val language= Locale.getDefault().language
        job= CoroutineScope(Dispatchers.IO).launch {
            val loadedFilm=useCase.execute(600,language)
            withContext(Dispatchers.Main){
                if(loadedFilm!=null){
                    filmLiveData.value= FilmDataView(
                            loadedFilm.title?:"",
                    loadedFilm.imageUrl?:"",
                        loadedFilm.description?:"",
                        loadedFilm.director?:"",
                        loadedFilm.rating,
                    )
                }

            }
        }
        //filmLiveData.value=FilmDataView(loadedFilm.title)
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
data class FilmDataView(val title:String,
                        val imageUrl:String,
                        val description:String,
                        val director: String,
                        val rating:Double)