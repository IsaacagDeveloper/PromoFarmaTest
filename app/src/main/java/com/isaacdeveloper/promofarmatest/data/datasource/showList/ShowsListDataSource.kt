package com.isaacdeveloper.promofarmatest.data.datasource.showList

import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

interface ShowsListDataSource {
    fun getShowsList(query: String): ShowsListResponseDomainModel
}