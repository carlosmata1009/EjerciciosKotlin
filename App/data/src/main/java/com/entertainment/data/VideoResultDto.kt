package com.entertainment.data


import com.google.gson.annotations.SerializedName

data class VideoResultDto(
    @SerializedName("id") val id: Int,
    @SerializedName("results") val results: List<VideoDto>
)