package com.isaacdeveloper.api.model.response.commonShowsModels

import com.google.gson.annotations.SerializedName

data class Rating (
	@SerializedName("average") val average : Double
)