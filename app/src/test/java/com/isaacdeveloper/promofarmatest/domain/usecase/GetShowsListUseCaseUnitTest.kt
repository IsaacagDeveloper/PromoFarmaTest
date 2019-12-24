package com.isaacdeveloper.promofarmatest.domain.usecase

import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class GetShowsListUseCaseUnitTest {

    private lateinit var getShowsListUseCase: GetShowsListUseCase
    private lateinit var showsRepository: ShowsRepository

    @BeforeEach
    fun init() {
        showsRepository = Mockito.mock(ShowsRepository::class.java)
        getShowsListUseCase = GetShowsListUseCase(showsRepository)
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
        Mockito.`when`(showsRepository.getShowsList("1")).thenReturn(showsListResponseDomainModel)

        // act
        val showsList = getShowsListUseCase.execute("1")

        // assert
        Assertions.assertEquals(showsListResponseDomainModel, showsList)
    }
}