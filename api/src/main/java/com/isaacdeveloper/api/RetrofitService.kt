package com.isaacdeveloper.api

import com.isaacdeveloper.api.kernel.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    val service: BaseAppApiService by lazy {
        val httpClient = OkHttpClient.Builder().build()
        val gsonConverterFactory = GsonConverterFactory.create()

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

        retrofit.create(BaseAppApiService::class.java)
    }

}