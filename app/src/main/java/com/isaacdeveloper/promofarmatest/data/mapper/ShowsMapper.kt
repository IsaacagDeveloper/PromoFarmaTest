package com.isaacdeveloper.promofarmatest.data.mapper

import com.isaacdeveloper.api.model.response.showsList.ShowsListApiResponseModel
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListDomainModel
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

fun showListToDomain(showsListResponseApiModel: ShowsListApiResponseModel): ShowsListResponseDomainModel {
    val state = stateToDomain(showsListResponseApiModel.responseState)
    val showsList = ShowsListResponseDomainModel(mutableListOf(), state)
    showsListResponseApiModel.dataList?.apply {
        for(show in this) {
            showsList.showList.add(
                ShowsListDomainModel(
                    show.id.toString(),
                    show.image.original,
                    show.name)
            )
        }
    }
    return showsList
}