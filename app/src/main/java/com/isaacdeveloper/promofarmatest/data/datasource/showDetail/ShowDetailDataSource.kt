package com.isaacdeveloper.promofarmatest.data.datasource.showDetail

import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailResponseDomainModel

interface ShowDetailDataSource {
    fun getShowDetail(query: String): ShowDetailResponseDomainModel
}