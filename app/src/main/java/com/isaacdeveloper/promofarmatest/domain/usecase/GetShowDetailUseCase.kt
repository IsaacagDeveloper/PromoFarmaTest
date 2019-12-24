package com.isaacdeveloper.promofarmatest.domain.usecase

import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailResponseDomainModel
import com.isaacdeveloper.promofarmatest.kernel.constants.EMPTY_TEXT

class GetShowDetailUseCase(val showsRepository: ShowsRepository) {
    fun execute(query: String): ShowDetailResponseDomainModel {
        val response = showsRepository.getShowDetail(query)

        if (response.state != DomainState.ERROR) {
            if (response.show.id.equals(EMPTY_TEXT)) {
                response.state = DomainState.EMPTY_DATA
            } else {
                response.state = DomainState.SUCCESS
            }
        }

        return response
    }
}