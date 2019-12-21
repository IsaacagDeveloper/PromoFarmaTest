package com.isaacdeveloper.api.model.response.commonShowsModels

import com.google.gson.annotations.SerializedName

data class Image (
	@SerializedName("medium") val medium : String,
	@SerializedName("original") val original : String
)