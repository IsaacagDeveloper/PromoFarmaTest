package com.isaacdeveloper.promofarmatest.presentation.showsList.presenter

import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel
import com.isaacdeveloper.promofarmatest.domain.usecase.GetMoreItemsUseCase
import com.isaacdeveloper.promofarmatest.domain.usecase.GetShowsListUseCase
import com.isaacdeveloper.promofarmatest.kernel.coroutines.backgroundContext
import com.isaacdeveloper.promofarmatest.kernel.coroutines.mainContext
import com.isaacdeveloper.promofarmatest.presentation.showsList.ui.ShowsListView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.*
import org.mockito.Mockito

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShowsListPresenterUnitTest {

    private lateinit var view: ShowsListView
    private lateinit var getShowsListUseCase: GetShowsListUseCase
    private lateinit var getMoreItemsUseCase: GetMoreItemsUseCase
    private lateinit var presenter: ShowsListPresenter

    @ExperimentalCoroutinesApi
    @BeforeAll
    internal fun initAll() {
        backgroundContext = Dispatchers.Unconfined
        mainContext = Dispatchers.Unconfined
    }

    @BeforeEach
    fun init() {
        getShowsListUseCase = Mockito.mock(GetShowsListUseCase::class.java)
        getMoreItemsUseCase = Mockito.mock(GetMoreItemsUseCase::class.java)
        view = Mockito.mock(ShowsListView::class.java)
        presenter = ShowsListPresenter(getShowsListUseCase, getMoreItemsUseCase)
    }

    @DisplayName("Should work correctly when we try to obtain the list of shows and the result is success")
    @Test
    fun testGetShowsSuccessList() {
        // arrange
        val showsListResponseDomainModel = ShowsListResponseDomainModel(
            mutableListOf(),
            DomainState.SUCCESS,
            "1"
        )
        Mockito.`when`(getShowsListUseCase.execute("1")).thenReturn(showsListResponseDomainModel)
        presenter.onAttach(view)

        // act
        presenter.onViewCreated()

        // assert
        Mockito.verify(view, Mockito.times(1)).hideLoading()
        Mockito.verify(view, Mockito.times(1)).showLoading()
        Mockito.verify(view, Mockito.times(1)).loadData(showsListResponseDomainModel.showList)
        Mockito.verify(view, Mockito.times(0)).errorOrEmptyData()
    }

    @DisplayName("Should work correctly when we try to obtain the list of shows and the result is error")
    @Test
    fun testGetShowsErrorList() {
        // arrange
        val showsListResponseDomainModel = ShowsListResponseDomainModel(
            mutableListOf(),
            DomainState.ERROR,
            "1"
        )
        Mockito.`when`(getShowsListUseCase.execute("1")).thenReturn(showsListResponseDomainModel)
        presenter.onAttach(view)

        // act
        presenter.onViewCreated()

        // assert
        Mockito.verify(view, Mockito.times(1)).hideLoading()
        Mockito.verify(view, Mockito.times(1)).showLoading()
        Mockito.verify(view, Mockito.times(0)).loadData(showsListResponseDomainModel.showList)
        Mockito.verify(view, Mockito.times(1)).errorOrEmptyData()
    }

    @DisplayName("Should work correctly when we try to obtain the list of shows and the result is empty data")
    @Test
    fun testGetShowsEmptyDataList() {
        // arrange
        val showsListResponseDomainModel = ShowsListResponseDomainModel(
            mutableListOf(),
            DomainState.EMPTY_DATA,
            "1"
        )
        Mockito.`when`(getShowsListUseCase.execute("1")).thenReturn(showsListResponseDomainModel)
        presenter.onAttach(view)

        // act
        presenter.onViewCreated()

        // assert
        Mockito.verify(view, Mockito.times(1)).hideLoading()
        Mockito.verify(view, Mockito.times(1)).showLoading()
        Mockito.verify(view, Mockito.times(0)).loadData(showsListResponseDomainModel.showList)
        Mockito.verify(view, Mockito.times(1)).errorOrEmptyData()
    }

    @DisplayName("Should work correctly when we try to obtain more shows and the result is success")
    @Test
    fun testGetMoreShowsSuccessList() {
        // arrange
        val showsListResponseDomainModel = ShowsListResponseDomainModel(
            mutableListOf(),
            DomainState.SUCCESS,
            "2"
        )
        Mockito.`when`(getMoreItemsUseCase.execute("2")).thenReturn(showsListResponseDomainModel)
        presenter.onAttach(view)

        // act
        presenter.onViewCreated()

        // assert
        Mockito.verify(view, Mockito.times(1)).hideLoading()
        Mockito.verify(view, Mockito.times(1)).showLoading()
        Mockito.verify(view, Mockito.times(1)).addData(showsListResponseDomainModel.showList)
        Mockito.verify(view, Mockito.times(0)).errorOrEmptyData()
    }

}