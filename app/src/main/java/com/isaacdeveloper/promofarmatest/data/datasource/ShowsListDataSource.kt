package com.isaacdeveloper.promofarmatest.data.datasource

import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

interface ShowsListDataSource {
    fun getShowsList(query: String): ShowsListResponseDomainModel
}