package com.isaacdeveloper.promofarmatest.domain.model

import com.isaacdeveloper.promofarmatest.domain.DomainState

data class ShowDetailResponseDomainModel(
    var show : ShowDetailDomainModel,
    var state : DomainState
)