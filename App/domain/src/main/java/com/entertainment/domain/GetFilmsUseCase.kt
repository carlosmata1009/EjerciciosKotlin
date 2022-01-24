package com.entertainment.domain

import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(
    private var repository: FilmRepository
){
    suspend fun execute(language:String)= repository.getFilms(language)
}