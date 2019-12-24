package com.isaacdeveloper.promofarmatest.di

import com.isaacdeveloper.api.RetrofitService
import com.isaacdeveloper.api.client.showDetail.ShowDetailClient
import com.isaacdeveloper.api.client.showDetail.ShowDetailClientImpl
import com.isaacdeveloper.api.client.showsList.ShowsListClient
import com.isaacdeveloper.api.client.showsList.ShowsListClientImpl
import com.isaacdeveloper.promofarmatest.data.datasource.showDetail.ShowDetailDataSource
import com.isaacdeveloper.promofarmatest.data.datasource.showDetail.ShowDetailDataSourceImpl
import com.isaacdeveloper.promofarmatest.data.datasource.showList.ShowsListDataSource
import com.isaacdeveloper.promofarmatest.data.datasource.showList.ShowsListDataSourceImpl
import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepositoryImpl
import com.isaacdeveloper.promofarmatest.domain.usecase.GetMoreItemsUseCase
import com.isaacdeveloper.promofarmatest.domain.usecase.GetShowsListUseCase
import com.isaacdeveloper.promofarmatest.presentation.showsList.presenter.ShowsListPresenter
import dagger.Module
import dagger.Provides

@Module
class ShowsListModule {

    @Provides
    fun provideShowDetailClient(retrofitService: RetrofitService) : ShowDetailClient =
        ShowDetailClientImpl(retrofitService)

    @Provides
    fun provideShowsListClient(retrofitService: RetrofitService) : ShowsListClient =
        ShowsListClientImpl(retrofitService)

    @Provides
    fun provideShowDetailDataSource(showDetailClient: ShowDetailClient) : ShowDetailDataSource =
        ShowDetailDataSourceImpl(showDetailClient)

    @Provides
    fun provideShowsListDataSource(showsListClient: ShowsListClient) : ShowsListDataSource =
        ShowsListDataSourceImpl(showsListClient)

    @Provides
    fun provideShowsRepository(showsListDataSource: ShowsListDataSource,
                               showDetailDataSource: ShowDetailDataSource) : ShowsRepository =
        ShowsRepositoryImpl(showsListDataSource, showDetailDataSource)

    @Provides
    fun provideGetShowsListUseCase(showsRepository: ShowsRepository) : GetShowsListUseCase =
        GetShowsListUseCase(showsRepository)

    @Provides
    fun provideGetMoreItemsUseCase(showsRepository: ShowsRepository) : GetMoreItemsUseCase =
        GetMoreItemsUseCase(showsRepository)

    @Provides
    fun provideShowsListPresenter(getShowsListUseCase: GetShowsListUseCase,
                                  getMoreItemsUseCase: GetMoreItemsUseCase) : ShowsListPresenter =
        ShowsListPresenter(getShowsListUseCase, getMoreItemsUseCase)

}