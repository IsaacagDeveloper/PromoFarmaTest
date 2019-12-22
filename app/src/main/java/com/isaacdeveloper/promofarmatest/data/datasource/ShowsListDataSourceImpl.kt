package com.isaacdeveloper.promofarmatest.data.datasource

import com.isaacdeveloper.api.client.showsList.ShowsListClient
import com.isaacdeveloper.promofarmatest.data.mapper.showListToDomain
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

class ShowsListDataSourceImpl(val showsListClient: ShowsListClient) : ShowsListDataSource {

    override fun getShowsList(query: String): ShowsListResponseDomainModel {
        val responseShowsClient = showsListClient.getShows(query)
        return showListToDomain(responseShowsClient)
    }
}