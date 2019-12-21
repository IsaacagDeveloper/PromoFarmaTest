package com.isaacdeveloper.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BaseAppApiService {

    //TODO change for the correct models

    @GET("/shows?page={num_page}")
    fun getShowsList(@Path("num_page") numPage: String): Call<Void>

    @GET("/shows/{id}")
    fun getShowDetail(@Path("id") showId: String): Call<Void>
}