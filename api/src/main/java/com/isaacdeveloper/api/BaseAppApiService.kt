package com.isaacdeveloper.api

import com.isaacdeveloper.api.model.response.commonShowsModels.Data
import com.isaacdeveloper.api.model.response.showDetail.ShowDetailApiResponseModel
import com.isaacdeveloper.api.model.response.showsList.ShowsListApiResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BaseAppApiService {

    @GET("/shows")
    fun getShowsList(@Query("num_page") numPage: String): Call<List<Data>>

    @GET("/shows/{id}")
    fun getShowDetail(@Path("id") showId: String): Call<Data>
}