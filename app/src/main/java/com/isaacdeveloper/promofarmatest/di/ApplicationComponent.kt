package com.isaacdeveloper.promofarmatest.di

import com.isaacdeveloper.promofarmatest.PromoFarmaApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app: PromoFarmaApp)
}