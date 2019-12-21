package com.isaacdeveloper.api.model.response.commonShowsModels

import com.google.gson.annotations.SerializedName

data class Country (
	@SerializedName("name") val name : String,
	@SerializedName("code") val code : String,
	@SerializedName("timezone") val timezone : String
)