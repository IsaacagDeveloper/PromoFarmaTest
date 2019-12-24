package com.isaacdeveloper.api.model.response.commonShowsModels

import com.google.gson.annotations.SerializedName

data class Schedule (
	@SerializedName("time") val time : String,
	@SerializedName("days") val days : List<String>
)