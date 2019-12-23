package com.isaacdeveloper.promofarmatest.domain.usecase

import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

class GetMoreItemsUseCase(val repository: ShowsRepository) {

    fun execute(query: String) : ShowsListResponseDomainModel =
        repository.getMoreItems(query)

}