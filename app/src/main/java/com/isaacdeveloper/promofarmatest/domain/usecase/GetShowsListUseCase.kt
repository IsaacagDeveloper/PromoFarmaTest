package com.isaacdeveloper.promofarmatest.domain.usecase

import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel

class GetShowsListUseCase(val showsRepository: ShowsRepository) {
    fun execute(query: String): ShowsListResponseDomainModel = showsRepository.getShowsList(query)
}