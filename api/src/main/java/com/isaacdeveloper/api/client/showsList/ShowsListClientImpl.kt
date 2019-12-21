package com.isaacdeveloper.api.client.showsList

import android.util.Log
import com.isaacdeveloper.api.RetrofitService
import com.isaacdeveloper.api.model.ResponseState
import com.isaacdeveloper.api.model.response.showsList.ShowsListApiResponseModel
import java.lang.Exception

class ShowsListClientImpl(
    val retrofitService: RetrofitService
): ShowsListClient {

    override fun getShows(query: String): ShowsListApiResponseModel {
        var showsListApiResponseModel = ShowsListApiResponseModel(null, ResponseState.ERROR)
        try {
            val endpoint = retrofitService.service.getShowsList(query)
            val apiResponse = endpoint.execute()
            if (apiResponse.isSuccessful) {
                apiResponse.body()?.apply {
                    showsListApiResponseModel = this
                    showsListApiResponseModel.responseState = ResponseState.SUCCESS
                }
            }
        }catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message.toString())
        }
        return showsListApiResponseModel
    }
}