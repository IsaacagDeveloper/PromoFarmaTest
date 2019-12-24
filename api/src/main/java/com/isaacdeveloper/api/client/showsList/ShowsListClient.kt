package com.isaacdeveloper.api.client.showsList

import com.isaacdeveloper.api.model.response.showsList.ShowsListApiResponseModel

interface ShowsListClient {
    fun getShows(query: String): ShowsListApiResponseModel
}