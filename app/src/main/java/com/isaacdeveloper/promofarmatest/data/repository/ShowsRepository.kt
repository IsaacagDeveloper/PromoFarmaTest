package com.isaacdeveloper.promofarmatest.data.repository

import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailResponseDomainModel
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

interface ShowsRepository {
    fun getShowsList(query: String): ShowsListResponseDomainModel
    fun getShowDetail(query: String): ShowDetailResponseDomainModel
    fun getMoreItems(query: String): ShowsListResponseDomainModel
}