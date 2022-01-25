package com.entertainment.data

import com.entertainment.domain.Film
import com.entertainment.domain.FilmRepository
import javax.inject.Inject

class FilmRepositoryIMPL @Inject constructor(
    private val dataSource:ServerDataSource
    ): FilmRepository {
    override suspend fun getFilm(id:Int,language: String): Film? {
        try{
            return dataSource.getFilm(id,language)
        }catch (e:Exception){
            return null
        }
    }

    override suspend fun getFilms(language: String): List<Film>? {
        try{
            return dataSource.getFilms(language)
        }catch (e:Exception){
            return null
        }
    }
}