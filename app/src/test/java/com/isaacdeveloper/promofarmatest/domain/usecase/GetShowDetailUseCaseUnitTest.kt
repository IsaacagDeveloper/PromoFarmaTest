package com.isaacdeveloper.promofarmatest.domain.usecase

import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailResponseDomainModel
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel
import com.isaacdeveloper.promofarmatest.modelBuilder.MockBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class GetShowDetailUseCaseUnitTest {

    private lateinit var getShowDetailUseCase: GetShowDetailUseCase
    private lateinit var showsRepository: ShowsRepository

    @BeforeEach
    fun init() {
        showsRepository = Mockito.mock(ShowsRepository::class.java)
        getShowDetailUseCase = GetShowDetailUseCase(showsRepository)
    }

    @DisplayName("Should return showDetaitResponseDomainModel")
    @Test
    fun testReturnShowDetailResponseDomainModel() {
        // arrange
        val showsDetailResponseDomainModel = ShowDetailResponseDomainModel(
            MockBuilder().buildShowDetailDomainModel(),
            DomainState.SUCCESS
        )
        Mockito.`when`(showsRepository.getShowDetail("1")).thenReturn(showsDetailResponseDomainModel)

        // act
        val show = getShowDetailUseCase.execute("1")

        // assert
        Assertions.assertEquals(showsDetailResponseDomainModel, show)
    }

}