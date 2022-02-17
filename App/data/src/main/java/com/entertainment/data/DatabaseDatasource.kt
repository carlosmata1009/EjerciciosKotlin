package com.entertainment.data

import com.entertainment.domain.Film
import javax.inject.Inject

class DatabaseDatasource @Inject constructor(private val database: AppDatabase) {
    suspend fun getFilmList(): List<Film> {
        return database.filmDao().getFilmList().map { it.toDomain() }
    }

    suspend fun getFilm(id: Int): Film? {
        return database.filmDao().getFilm(id)?.toDomain()
    }

    suspend fun updateFilmList(films: List<Film>) {
        database.filmDao().insertAll(films.map { it.toEntity() })
    }

    suspend fun clearFilmList() {
        database.filmDao().deleteAll()
    }
    private fun FilmEntity.toDomain(): Film =
        Film(
            id,
            title,
            imageUrl,
            description,
            director,
            0.0,
            ""
        )

    private fun Film.toEntity(): FilmEntity =
        FilmEntity(
            id,
            title,
            imageUrl,
            "",
            "",
            rating,
            ""
        )
}