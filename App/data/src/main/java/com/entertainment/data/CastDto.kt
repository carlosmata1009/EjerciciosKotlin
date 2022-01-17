package com.entertainment.data

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("Know_for_department") val role:String,
    @SerializedName("name") val name:String
)

