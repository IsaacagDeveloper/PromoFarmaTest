package com.isaacdeveloper.promofarmatest.di

import com.isaacdeveloper.promofarmatest.presentation.showsList.ui.fragment.ShowsListFragment
import dagger.Subcomponent

@Subcomponent(modules = [ShowsListModule::class])
interface ShowsListComponent {
    fun inject(fragment: ShowsListFragment)
}