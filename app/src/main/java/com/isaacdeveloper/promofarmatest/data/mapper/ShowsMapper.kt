package com.isaacdeveloper.promofarmatest.data.mapper

import com.isaacdeveloper.api.model.response.showDetail.ShowDetailApiResponseModel
import com.isaacdeveloper.api.model.response.showsList.ShowsListApiResponseModel
import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailDomainModel
import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailResponseDomainModel
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListDomainModel
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel
import com.isaacdeveloper.promofarmatest.kernel.constants.EMPTY_TEXT

fun showListToDomain(showsListResponseApiModel: ShowsListApiResponseModel): ShowsListResponseDomainModel {
    val state = stateToDomain(showsListResponseApiModel.responseState)
    val page = showsListResponseApiModel.page
    val showsList = ShowsListResponseDomainModel(mutableListOf(), state, page)
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

fun showDetailToDomain(showDetailApiResponseModel: ShowDetailApiResponseModel) : ShowDetailResponseDomainModel {
    val state = stateToDomain(showDetailApiResponseModel.responseState)
    var show = initShowDetail(state)
    showDetailApiResponseModel.data?.apply {
        show = ShowDetailResponseDomainModel(
            ShowDetailDomainModel(
                this.id.toString(),
                this.image.original,
                this.name,
                this.rating.average.toString(),
                this.summary
            ),
            state
        )
    }
    return show
}

private fun initShowDetail(state: DomainState): ShowDetailResponseDomainModel =
    ShowDetailResponseDomainModel(
        ShowDetailDomainModel(EMPTY_TEXT, EMPTY_TEXT, EMPTY_TEXT, EMPTY_TEXT, EMPTY_TEXT), state)

