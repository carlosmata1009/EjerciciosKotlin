package com.entertainment.data

import com.google.gson.annotations.SerializedName

data class dto (
    @SerializedName("id") val id:Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val description:String,
    @SerializedName("vote_average") val rating:Double,
    @SerializedName("poster_path") val imageURL:String
    ){}