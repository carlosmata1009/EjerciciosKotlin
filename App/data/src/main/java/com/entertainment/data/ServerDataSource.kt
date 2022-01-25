package com.entertainment.data

import com.entertainment.domain.Film
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ServerDataSource @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: FilmApi=retrofit.create(FilmApi::class.java)
    suspend fun getFilm(id:Int, language: String): Film {
        val filmDto = api.getFilm(id,language)
        val creditsDto=api.getCredits(id)
        val director= creditsDto.cast.firstOrNull(){it.role=="Directing"}?.name?:""
        val completeUrl="https://image.tmdb.org/t/p/w50${filmDto.imageURL}"

        return Film(filmDto.title,filmDto.imageURL,filmDto.description,director,filmDto.rating)
    }
    suspend fun getFilms(language: String):List<Film>{
        return api.getPopular(language).films.map{
            Film(it.id, getFullURL(it.imageUrl),it.description,it.rating,null)
        }
}   
}

    suspend fun getFullURL(imageUrl:String?)=
        imageUrl?.let{
            "https://image.tmdb.org/t/p/w500$it"
        }
