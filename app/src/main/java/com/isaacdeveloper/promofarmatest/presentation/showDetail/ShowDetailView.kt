package com.isaacdeveloper.promofarmatest.presentation.showDetail

import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailDomainModel

interface ShowDetailView {
    fun printShowData(show: ShowDetailDomainModel)
    fun showError()
    fun showLoading()
    fun hideLoading()
}