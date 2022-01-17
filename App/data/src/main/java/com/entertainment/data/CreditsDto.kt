package com.entertainment.data

import com.google.gson.annotations.SerializedName

data class CreditsDto (
    @SerializedName("cast") val cast: List<CastDto>
){}