package com.isaacdeveloper.promofarmatest.kernel.ui

import androidx.fragment.app.Fragment
import com.isaacdeveloper.promofarmatest.PromoFarmaApp

abstract class BaseFragment : Fragment() {
    fun getApplication() : PromoFarmaApp {
        return activity!!.application as PromoFarmaApp
    }
}