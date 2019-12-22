package com.isaacdeveloper.promofarmatest.presentation.showsList.presenter

import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.usecase.GetShowsListUseCase
import com.isaacdeveloper.promofarmatest.kernel.constants.FIRST_PAGE
import com.isaacdeveloper.promofarmatest.kernel.coroutines.backgroundContext
import com.isaacdeveloper.promofarmatest.kernel.presenter.CoroutinesPresenter
import com.isaacdeveloper.promofarmatest.presentation.showsList.ui.ShowsListView
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ShowsListPresenter(val getShowsListUseCase: GetShowsListUseCase) : CoroutinesPresenter<ShowsListView>() {

    fun onViewCreated() {
        view?.showLoading()
        launch {
            async(backgroundContext) {
                getShowsListUseCase.execute(FIRST_PAGE)
            }.await().run {
                if(this.state == DomainState.SUCCESS) {
                    view?.loadData(this.showList)
                } else {
                    view?.errorOrEmptyData()
                }
                view?.hideLoading()
            }
        }
    }

    fun showClicked(showId: String) {
        view?.openDetailView(showId)
    }

}