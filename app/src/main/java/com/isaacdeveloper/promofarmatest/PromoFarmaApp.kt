package com.isaacdeveloper.promofarmatest

import android.app.Application
import com.isaacdeveloper.promofarmatest.di.ApplicationComponent
import com.isaacdeveloper.promofarmatest.di.ApplicationModule
import com.isaacdeveloper.promofarmatest.di.DaggerApplicationComponent

class PromoFarmaApp : Application() {

    val component : ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}