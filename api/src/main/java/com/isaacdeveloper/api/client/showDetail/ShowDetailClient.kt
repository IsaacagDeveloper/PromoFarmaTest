package com.isaacdeveloper.api.client.showDetail

import com.isaacdeveloper.api.model.response.showDetail.ShowDetailApiResponseModel

interface ShowDetailClient {
    fun getShow(query: String): ShowDetailApiResponseModel
}