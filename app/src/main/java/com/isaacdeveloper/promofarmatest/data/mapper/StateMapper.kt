package com.isaacdeveloper.promofarmatest.data.mapper

import com.isaacdeveloper.api.model.ResponseState
import com.isaacdeveloper.promofarmatest.domain.DomainState

fun stateToDomain(responseState: ResponseState): DomainState =
    when(responseState) {
        ResponseState.SUCCESS -> DomainState.SUCCESS
        ResponseState.ERROR -> DomainState.ERROR
        ResponseState.EMPTY_DATA -> DomainState.EMPTY_DATA
    }