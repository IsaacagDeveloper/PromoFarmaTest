package com.isaacdeveloper.promofarmatest.domain.usecase

import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailResponseDomainModel

class GetShowDetailUseCase(val showsRepository: ShowsRepository) {
    fun execute(query: String): ShowDetailResponseDomainModel = showsRepository.getShowDetail(query)
}