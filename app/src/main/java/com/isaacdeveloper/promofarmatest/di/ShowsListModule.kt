package com.isaacdeveloper.promofarmatest.di

import com.isaacdeveloper.api.RetrofitService
import com.isaacdeveloper.api.client.showsList.ShowsListClient
import com.isaacdeveloper.api.client.showsList.ShowsListClientImpl
import com.isaacdeveloper.promofarmatest.data.datasource.ShowsListDataSource
import com.isaacdeveloper.promofarmatest.data.datasource.ShowsListDataSourceImpl
import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepository
import com.isaacdeveloper.promofarmatest.data.repository.ShowsRepositoryImpl
import com.isaacdeveloper.promofarmatest.domain.usecase.GetShowsListUseCase
import com.isaacdeveloper.promofarmatest.presentation.showsList.presenter.ShowsListPresenter
import dagger.Module
import dagger.Provides

@Module
class ShowsListModule {

    @Provides
    fun provideShowsListClient(retrofitService: RetrofitService) : ShowsListClient =
        ShowsListClientImpl(retrofitService)

    @Provides
    fun provideShowsListDataSource(showsListClient: ShowsListClient) : ShowsListDataSource =
        ShowsListDataSourceImpl(showsListClient)

    @Provides
    fun provideShowsRepository(showsListDataSource: ShowsListDataSource) : ShowsRepository =
        ShowsRepositoryImpl(showsListDataSource)

    @Provides
    fun provideGetShowsListUseCase(showsRepository: ShowsRepository) : GetShowsListUseCase =
        GetShowsListUseCase(showsRepository)

    @Provides
    fun provideShowsListPresenter(getShowsListUseCase: GetShowsListUseCase) : ShowsListPresenter =
        ShowsListPresenter(getShowsListUseCase)

}