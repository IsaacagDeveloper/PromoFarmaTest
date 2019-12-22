package com.isaacdeveloper.promofarmatest.domain.model

import com.isaacdeveloper.promofarmatest.domain.DomainState

data class ShowsListResponseDomainModel(
    var showList : MutableList<ShowsListDomainModel>,
    var state : DomainState
)