package com.isaacdeveloper.promofarmatest.data.repository

import com.isaacdeveloper.promofarmatest.data.datasource.showDetail.ShowDetailDataSource
import com.isaacdeveloper.promofarmatest.data.datasource.showList.ShowsListDataSource
import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailResponseDomainModel
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

class ShowsRepositoryImpl(val showsListDataSource: ShowsListDataSource,
                          val showDetailDataSource: ShowDetailDataSource
) : ShowsRepository {

    override fun getShowsList(query: String): ShowsListResponseDomainModel =
        showsListDataSource.getShowsList(query)

    override fun getShowDetail(query: String): ShowDetailResponseDomainModel =
        showDetailDataSource.getShowDetail(query)
}