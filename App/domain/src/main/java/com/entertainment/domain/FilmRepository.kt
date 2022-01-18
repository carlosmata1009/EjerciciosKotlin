package com.entertainment.domain

interface FilmRepository {
    suspend fun getFilm(id: Int, language:String):Film?
}