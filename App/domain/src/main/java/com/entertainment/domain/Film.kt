package com.entertainment.domain

data class Film (
    val id:Int,
    val title:String,
    val imageUrl:String?,
    val description:String?,
    val director: String?,
    val rating:Double,
    val videoId:String?
    )

