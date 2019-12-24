package com.isaacdeveloper.promofarmatest.data.datasource.showList

import com.isaacdeveloper.api.client.showsList.ShowsListClient
import com.isaacdeveloper.promofarmatest.data.datasource.showList.ShowsListDataSource
import com.isaacdeveloper.promofarmatest.data.mapper.showListToDomain
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

class ShowsListDataSourceImpl(val showsListClient: ShowsListClient) :
    ShowsListDataSource {

    override fun getShowsList(query: String): ShowsListResponseDomainModel {
        val responseShowsClient = showsListClient.getShows(query)
        return showListToDomain(responseShowsClient)
    }

    override fun getMoreItems(query: String): ShowsListResponseDomainModel {
        val responseShowsClient = showsListClient.getShows(query)
        return showListToDomain(responseShowsClient)
    }
}