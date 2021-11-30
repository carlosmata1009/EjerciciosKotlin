package com.entertainment.data

import com.entertainment.domain.Film
import com.entertainment.domain.FilmRepository
import javax.inject.Inject

class FilmRepositoryIMPL @Inject constructor(): FilmRepository {
    override fun getFilm()= Film("","","",1.0)
}