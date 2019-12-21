package com.isaacdeveloper.promofarmatest.presentation.showsList.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isaacdeveloper.promofarmatest.R
import com.isaacdeveloper.promofarmatest.kernel.ui.BaseFragment

class ShowsListFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ShowsListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shows_list, container, false)
    }

}