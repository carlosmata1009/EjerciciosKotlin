package com.entertainment.data

import com.entertainment.domain.Film
import com.entertainment.domain.FilmRepository
import javax.inject.Inject

class FilmRepositoryIMPL @Inject constructor(
    private val dataSource:ServerDataSource,
    private val databaseDataSource: DatabaseDatasource
    ): FilmRepository {

    override suspend fun getFilm(filmPos: Int, language: String): Film? {
        return runCatching {
            val filmFromServer = dataSource.getFilm(filmPos, language)
            databaseDataSource.updateFilmList(listOf(filmFromServer))
            filmFromServer
        }.getOrNull() ?: kotlin.run {
            databaseDataSource.getFilm(filmPos)
        }

    }

    override suspend fun getFilms(language: String): List<Film> {
        return runCatching {
            val filmListFromServer = dataSource.getFilms(language)
            databaseDataSource.clearFilmList()
            databaseDataSource.updateFilmList(filmListFromServer ?: emptyList())

            filmListFromServer
        }.getOrNull() ?: kotlin.run {
            databaseDataSource.getFilmList()
        }
    }
}