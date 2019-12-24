package com.isaacdeveloper.promofarmatest.domain.usecase

import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

class GetMoreItemsUseCase(val repository: ShowsRepository) {

    fun execute(query: String) : ShowsListResponseDomainModel {
        val response = repository.getMoreItems(query)

        if (response.state != DomainState.ERROR) {
            if (response.showList.isEmpty()) {
                response.state = DomainState.EMPTY_DATA
            } else {
                response.state = DomainState.SUCCESS
            }
        }

        return response
    }

}