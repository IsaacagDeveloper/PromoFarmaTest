package com.isaacdeveloper.promofarmatest.data.repository

import com.isaacdeveloper.promofarmatest.data.datasource.ShowsListDataSource
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

class ShowsRepositoryImpl(val showsListDataSource: ShowsListDataSource) : ShowsRepository {

    override fun getShowsList(query: String): ShowsListResponseDomainModel =
        showsListDataSource.getShowsList(query)
}