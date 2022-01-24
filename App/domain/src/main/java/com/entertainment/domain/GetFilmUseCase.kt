package com.entertainment.domain

import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private var repository: FilmRepository
){
    suspend fun execute(id:Int,language:String)= repository.getFilm(id, language)
}