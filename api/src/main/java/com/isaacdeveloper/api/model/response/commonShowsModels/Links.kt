package com.isaacdeveloper.api.model.response.commonShowsModels

import com.google.gson.annotations.SerializedName

data class Links (
    @SerializedName("self") val self : Self,
    @SerializedName("previousepisode") val previousepisode : Previousepisode
)