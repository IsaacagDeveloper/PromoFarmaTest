package com.isaacdeveloper.promofarmatest.presentation.showsList.ui

import com.isaacdeveloper.promofarmatest.domain.model.ShowsListDomainModel

interface ShowsListView {
    fun showLoading()
    fun hideLoading()
    fun openDetailView(showId: String, title: String)
    fun loadData(showListSend: MutableList<ShowsListDomainModel>)
    fun addData(newShowsSend: MutableList<ShowsListDomainModel>)
    fun errorOrEmptyData()
}