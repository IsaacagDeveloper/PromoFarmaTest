package com.isaacdeveloper.promofarmatest.di

import com.isaacdeveloper.promofarmatest.presentation.showDetail.ui.fragment.ShowDetailFragment
import dagger.Subcomponent

@Subcomponent(modules = [ShowDetailModule::class])
interface ShowDetailComponent {
    fun inject(fragment: ShowDetailFragment)
}