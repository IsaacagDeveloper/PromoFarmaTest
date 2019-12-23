package com.isaacdeveloper.promofarmatest.presentation.showsList.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.isaacdeveloper.promofarmatest.R
import com.isaacdeveloper.promofarmatest.di.ShowsListModule
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListDomainModel
import com.isaacdeveloper.promofarmatest.kernel.constants.NUM_COLUMNS
import com.isaacdeveloper.promofarmatest.kernel.ui.BaseFragment
import com.isaacdeveloper.promofarmatest.presentation.showDetail.ui.activity.ShowDetailActivity
import com.isaacdeveloper.promofarmatest.presentation.showsList.presenter.ShowsListPresenter
import com.isaacdeveloper.promofarmatest.presentation.showsList.ui.OnShowsClick
import com.isaacdeveloper.promofarmatest.presentation.showsList.ui.ShowsListView
import com.isaacdeveloper.promofarmatest.presentation.showsList.ui.activity.ShowsListActivity
import com.isaacdeveloper.promofarmatest.presentation.showsList.ui.adapter.ShowsListAdapter
import kotlinx.android.synthetic.main.fragment_shows_list.*
import javax.inject.Inject

class ShowsListFragment : BaseFragment(), OnShowsClick, ShowsListView {

    @Inject
    lateinit var presenter : ShowsListPresenter

    private lateinit var mAdapter: ShowsListAdapter
    private var onShowsClick: OnShowsClick? = null

    companion object {
        @JvmStatic
        fun newInstance() = ShowsListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getApplication().component.showsListComponent(ShowsListModule()).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shows_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        presenter.onViewCreated()
        initAdapterAndRecyclerView()
    }

    private fun initAdapterAndRecyclerView() {
        mAdapter = ShowsListAdapter(context!!, mutableListOf()) { onShowsClick(it) }
        val mLayoutManager = StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL)
        rvShowsList.layoutManager = mLayoutManager
        rvShowsList.adapter = mAdapter
    }

    override fun onShowsClick(show: ShowsListDomainModel) {
        presenter.showClicked(show.id, show.name)
    }

    override fun showLoading() {
        activity?.apply {
            if (this is ShowsListActivity) {
                this.showLoading()
            }
        }
    }

    override fun hideLoading() {
        activity?.apply {
            if (this is ShowsListActivity) {
                this.hideLoading()
            }
        }
    }

    override fun openDetailView(showId: String, title: String) {
        val intent = Intent(context, ShowDetailActivity::class.java)
        intent.putExtra(ShowDetailActivity.SHOW_ID_SEND, showId)
        intent.putExtra(ShowDetailActivity.SHOW_TITLE_SEND, title)
        activity!!.startActivity(intent)
    }

    override fun loadData(showListSend: MutableList<ShowsListDomainModel>) {
        mAdapter.addAll(showListSend)
        mAdapter.notifyDataSetChanged()
    }

    override fun errorOrEmptyData() {
        activity?.apply {
            if (this is ShowsListActivity) {
                this.showErrorOrEmptyData()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}