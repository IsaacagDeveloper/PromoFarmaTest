package com.isaacdeveloper.promofarmatest.presentation.showDetail.presenter

import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.usecase.GetShowDetailUseCase
import com.isaacdeveloper.promofarmatest.kernel.coroutines.backgroundContext
import com.isaacdeveloper.promofarmatest.kernel.presenter.CoroutinesPresenter
import com.isaacdeveloper.promofarmatest.presentation.showDetail.ShowDetailView
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ShowDetailPresenter(
    val getShowDetailUseCase: GetShowDetailUseCase
) : CoroutinesPresenter<ShowDetailView>() {

    fun onViewCreated(id: String){
        view?.showLoading()
        launch {
            async(backgroundContext) {
                getShowDetailUseCase.execute(id)
            }.await().run {
                if (this.state == DomainState.SUCCESS){
                    view?.printShowData(this.show)
                } else {
                    view?.showError()
                }
                view?.hideLoading()
            }
        }
    }

}