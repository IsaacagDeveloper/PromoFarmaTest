package com.isaacdeveloper.promofarmatest.kernel.presenter

import com.isaacdeveloper.promofarmatest.kernel.coroutines.mainContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class CoroutinesPresenter<T> : CoroutineScope, Presenter<T>() {
    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + mainContext

    override fun onAttach(view: T) {
        super.onAttach(view)
        job = Job()
    }

    override fun onDetach() {
        super.onDetach()
        job.cancel()
    }
}