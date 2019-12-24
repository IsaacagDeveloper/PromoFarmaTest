package com.isaacdeveloper.promofarmatest.domain.usecase

import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class GetMoreItemsUseCaseUnitTest {

    private lateinit var getMoreItemsUseCase: GetMoreItemsUseCase
    private lateinit var showsRepository: ShowsRepository

    @BeforeEach
    fun init() {
        showsRepository = Mockito.mock(ShowsRepository::class.java)
        getMoreItemsUseCase = GetMoreItemsUseCase(showsRepository)
    }

    @DisplayName("Should return showsListResponseDomainModel")
    @Test
    fun testReturnShowsListResponseDomainModel() {
        // arrange
        val showsListResponseDomainModel = ShowsListResponseDomainModel(
            mutableListOf(),
            DomainState.SUCCESS,
            "1"
        )
        Mockito.`when`(showsRepository.getMoreItems("1")).thenReturn(showsListResponseDomainModel)

        // act
        val showsList = getMoreItemsUseCase.execute("1")

        // assert
        Assertions.assertEquals(showsListResponseDomainModel, showsList)
    }

}