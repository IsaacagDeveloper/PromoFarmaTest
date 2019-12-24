package com.isaacdeveloper.promofarmatest.presentation.showsList.ui

import com.isaacdeveloper.promofarmatest.domain.model.ShowsListDomainModel

interface OnShowsClick {
    fun onShowsClick(show: ShowsListDomainModel)
}