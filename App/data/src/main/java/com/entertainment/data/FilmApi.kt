package com.entertainment.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL="https://api.themoviedb.org/3/"
const val API_KEY="266b341f19aebdd371cfac0e173e7195"
interface FilmApi {
    @GET("movie/{id}")
    suspend fun getFilm(
        @Path("id") filmId: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String = API_KEY
    ): dto

    @GET("movie/{id}/credits")
    suspend fun getCredits(
        @Path("id") filmId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): CreditsDto
}