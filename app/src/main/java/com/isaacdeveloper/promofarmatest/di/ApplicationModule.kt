package com.isaacdeveloper.promofarmatest.di

import android.content.Context
import com.isaacdeveloper.api.RetrofitService
import com.isaacdeveloper.promofarmatest.PromoFarmaApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val app : PromoFarmaApp) {
    @Provides
    @Singleton
    fun provideContext() : Context = app.applicationContext

    @Provides
    @Singleton
    fun provideApiService(): RetrofitService = RetrofitService()
}