package com.entertainment.data

import com.entertainment.domain.Film
import javax.inject.Inject

class HardcodedDataSource @Inject constructor(){
    fun getFilm()= Film(0,"","","","",1.0,null)
}
