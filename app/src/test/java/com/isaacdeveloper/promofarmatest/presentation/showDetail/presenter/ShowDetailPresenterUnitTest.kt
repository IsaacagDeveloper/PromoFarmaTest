package com.isaacdeveloper.promofarmatest.presentation.showDetail.presenter

import com.isaacdeveloper.promofarmatest.domain.usecase.GetShowDetailUseCase
import com.isaacdeveloper.promofarmatest.kernel.coroutines.backgroundContext
import com.isaacdeveloper.promofarmatest.kernel.coroutines.mainContext
import com.isaacdeveloper.promofarmatest.modelBuilder.MockBuilder
import com.isaacdeveloper.promofarmatest.presentation.showDetail.ShowDetailView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.*
import org.mockito.Mockito

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShowDetailPresenterUnitTest {

    private lateinit var view: ShowDetailView
    private lateinit var getShowDetailUseCase: GetShowDetailUseCase
    private lateinit var presenter: ShowDetailPresenter

    @ExperimentalCoroutinesApi
    @BeforeAll
    internal fun initAll() {
        backgroundContext = Dispatchers.Unconfined
        mainContext = Dispatchers.Unconfined
    }

    @BeforeEach
    fun init() {
        getShowDetailUseCase = Mockito.mock(GetShowDetailUseCase::class.java)
        view = Mockito.mock(ShowDetailView::class.java)
        presenter = ShowDetailPresenter(getShowDetailUseCase)
    }

    @DisplayName("Should work correctly when we try to obtain the information of a show from the id we are sending")
    @Test
    fun testGetShowSuccess() {
        // arrange
        val showCreated = MockBuilder().buildShowDetailResponseDomainModel()
        Mockito.`when`(getShowDetailUseCase.execute("1")).thenReturn(showCreated)
        presenter.onAttach(view)

        // act
        presenter.onViewCreated("1")

        // assert
        Mockito.verify(view, Mockito.times(1)).printShowData(showCreated.show)
    }
}