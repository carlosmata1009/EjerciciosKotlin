package com.entertainment.domain

import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private var repository: FilmRepository
){
    fun execute()= repository.getFilm()
}