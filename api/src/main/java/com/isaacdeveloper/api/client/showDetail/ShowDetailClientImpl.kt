package com.isaacdeveloper.api.client.showDetail

import android.util.Log
import com.isaacdeveloper.api.RetrofitService
import com.isaacdeveloper.api.model.ResponseState
import com.isaacdeveloper.api.model.response.showDetail.ShowDetailApiResponseModel

class ShowDetailClientImpl(
    val retrofitService: RetrofitService
): ShowDetailClient {

    override fun getShow(query: String): ShowDetailApiResponseModel {
        var showDetailApiResponseModel = ShowDetailApiResponseModel(null, ResponseState.ERROR)
        try {
            val endpoint = retrofitService.service.getShowDetail(query)
            val apiResponse = endpoint.execute()
            if (apiResponse.isSuccessful) {
                apiResponse.body()?.apply {
                    showDetailApiResponseModel.data = this
                    showDetailApiResponseModel.responseState = ResponseState.SUCCESS
                }
            }
        }catch (e: Exception) {
            Log.e(javaClass.simpleName, e.message.toString())
        }
        return showDetailApiResponseModel
    }
}