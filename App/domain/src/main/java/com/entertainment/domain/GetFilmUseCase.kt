package com.entertainment.domain

import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private var repository: FilmRepository
){
    fun run()= repository.getFilm()
}