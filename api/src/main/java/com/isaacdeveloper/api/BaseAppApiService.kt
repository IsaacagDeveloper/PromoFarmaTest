package com.isaacdeveloper.api

import com.isaacdeveloper.api.model.response.showDetail.ShowDetailApiResponseModel
import com.isaacdeveloper.api.model.response.showsList.ShowsListApiResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BaseAppApiService {

    @GET("/shows?page={num_page}")
    fun getShowsList(@Path("num_page") numPage: String): Call<ShowsListApiResponseModel>

    @GET("/shows/{id}")
    fun getShowDetail(@Path("id") showId: String): Call<ShowDetailApiResponseModel>
}