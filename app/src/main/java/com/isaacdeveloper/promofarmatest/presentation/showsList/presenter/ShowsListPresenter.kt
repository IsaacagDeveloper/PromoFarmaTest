package com.isaacdeveloper.promofarmatest.presentation.showsList.presenter

import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListResponseDomainModel
import com.isaacdeveloper.promofarmatest.domain.usecase.GetMoreItemsUseCase
import com.isaacdeveloper.promofarmatest.domain.usecase.GetShowsListUseCase
import com.isaacdeveloper.promofarmatest.kernel.constants.FIRST_PAGE
import com.isaacdeveloper.promofarmatest.kernel.constants.NEXT_PAGE
import com.isaacdeveloper.promofarmatest.kernel.coroutines.backgroundContext
import com.isaacdeveloper.promofarmatest.kernel.presenter.CoroutinesPresenter
import com.isaacdeveloper.promofarmatest.presentation.showsList.ui.ShowsListView
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ShowsListPresenter(val getShowsListUseCase: GetShowsListUseCase,
                         val getMoreItemsUseCase: GetMoreItemsUseCase) : CoroutinesPresenter<ShowsListView>() {

    private lateinit var show: ShowsListResponseDomainModel
    private var isLoading = false

    fun onViewCreated() {
        view?.showLoading()
        launch {
            async(backgroundContext) {
                getShowsListUseCase.execute(FIRST_PAGE)
            }.await().run {
                if(this.state == DomainState.SUCCESS) {
                    show = this
                    view?.loadData(this.showList)
                } else {
                    view?.errorOrEmptyData()
                }
                view?.hideLoading()
            }
        }
    }

    fun onScrollEnd() {
        view?.showLoading()
        launch {
            async(backgroundContext) {
                show.page = (show.page.toInt() + NEXT_PAGE).toString()
                getMoreItemsUseCase.execute(show.page)
            }.await().run {
                if(this.state == DomainState.SUCCESS) {
                    show.showList.addAll(this.showList)
                    show.state = this.state
                    show.page = this.page
                    view?.addData(this.showList)
                } else if (this.state == DomainState.ERROR){
                    show.page = (show.page.toInt() - NEXT_PAGE).toString()
                    view?.errorOrEmptyData()
                }
                view?.hideLoading()
            }
        }
    }

    fun showClicked(showId: String, title: String) {
        view?.openDetailView(showId, title)
    }

    fun setIsLoading(isLoadingNow: Boolean) {
        isLoading = isLoadingNow
    }

    fun getIsLoading() : Boolean {
        return isLoading
    }

}