package com.entertainment.data

import com.entertainment.domain.Film
import com.entertainment.domain.FilmRepository
import javax.inject.Inject

class FilmRepositoryIMPL @Inject constructor(
    private val dataSource:HardcodedDataSource
    ): FilmRepository {
    override fun getFilm(): Film {
        return dataSource.getFilm();
    }
}