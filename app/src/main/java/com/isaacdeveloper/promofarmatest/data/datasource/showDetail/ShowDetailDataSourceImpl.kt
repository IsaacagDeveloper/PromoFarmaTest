package com.isaacdeveloper.promofarmatest.data.datasource.showDetail

import com.isaacdeveloper.api.client.showDetail.ShowDetailClient
import com.isaacdeveloper.promofarmatest.data.mapper.showDetailToDomain
import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailResponseDomainModel

class ShowDetailDataSourceImpl(val showDetailClient: ShowDetailClient) : ShowDetailDataSource {

    override fun getShowDetail(query: String): ShowDetailResponseDomainModel {
        val responseShowDetailClient = showDetailClient.getShow(query)
        return showDetailToDomain(responseShowDetailClient)
    }
}