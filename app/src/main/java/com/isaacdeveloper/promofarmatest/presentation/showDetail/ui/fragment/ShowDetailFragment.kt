package com.isaacdeveloper.promofarmatest.presentation.showDetail.ui.fragment

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.isaacdeveloper.promofarmatest.R
import com.isaacdeveloper.promofarmatest.di.ShowDetailModule
import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailDomainModel
import com.isaacdeveloper.promofarmatest.kernel.ui.BaseFragment
import com.isaacdeveloper.promofarmatest.presentation.showDetail.ShowDetailView
import com.isaacdeveloper.promofarmatest.presentation.showDetail.presenter.ShowDetailPresenter
import com.isaacdeveloper.promofarmatest.presentation.showDetail.ui.activity.ShowDetailActivity
import kotlinx.android.synthetic.main.fragment_show_detail.*
import javax.inject.Inject

class ShowDetailFragment : BaseFragment(), ShowDetailView {

    @Inject
    lateinit var presenter : ShowDetailPresenter

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
        getApplication().component.showDetailComponent(ShowDetailModule()).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        arguments?.getString(KEY_SHOW_ID_DETAIL)?.also {id -> String
            presenter.onViewCreated(id)
        }
    }

    override fun printShowData(show: ShowDetailDomainModel) {
        activity?.apply {
            if (this is ShowDetailActivity) {
                setParallaxImage(show.url)
            }
        }
        txtShowName.text = show.name
        txtShowRating.text = show.rating
        txtShowSinopsis.text = Html.fromHtml(show.sinopsis, Html.FROM_HTML_MODE_LEGACY)
    }

    override fun showError() {
        Toast.makeText(context, getString(R.string.message_error), Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        activity?.apply {
            if (this is ShowDetailActivity) {
                this.showLoading()
            }
        }
    }

    override fun hideLoading() {
        activity?.apply {
            if (this is ShowDetailActivity) {
                this.hideLoading()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}