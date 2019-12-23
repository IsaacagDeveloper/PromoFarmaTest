package com.isaacdeveloper.promofarmatest.presentation.showDetail.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isaacdeveloper.promofarmatest.R
import com.isaacdeveloper.promofarmatest.kernel.ui.BaseFragment

class ShowDetailFragment : BaseFragment() {

    companion object {
        const val KEY_SHOW_ID_DETAIL = "KEY_SHOW_ID_DETAIL"
        @JvmStatic
        fun newInstance(id: String) = ShowDetailFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_SHOW_ID_DETAIL, id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_detail, container, false)
    }

}