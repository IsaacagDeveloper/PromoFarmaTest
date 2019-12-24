package com.isaacdeveloper.promofarmatest.domain.usecase

import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel
import com.isaacdeveloper.promofarmatest.kernel.constants.EMPTY_TEXT

class GetShowsListUseCase(val showsRepository: ShowsRepository) {
    fun execute(query: String): ShowsListResponseDomainModel {
        val response = showsRepository.getShowsList(query)

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