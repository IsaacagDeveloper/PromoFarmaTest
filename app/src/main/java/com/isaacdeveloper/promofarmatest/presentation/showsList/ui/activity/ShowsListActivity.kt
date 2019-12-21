package com.isaacdeveloper.promofarmatest.presentation.showsList.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.isaacdeveloper.promofarmatest.R
import com.isaacdeveloper.promofarmatest.presentation.showsList.ui.fragment.ShowsListFragment
import kotlinx.android.synthetic.main.activity_with_toolbar.*

class ShowsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_toolbar)
        setSupportActionBar(toolbar)
        initTitle()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ShowsListFragment.newInstance(), ShowsListFragment::class.java.name)
                .commit()
        }
    }

    private fun initTitle() {
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbarTitle.text = getString(R.string.app_name)
    }

    fun showLoading() {
        rlLoadingProductList.visibility = View.VISIBLE
    }

    fun hideLoading() {
        rlLoadingProductList.visibility = View.GONE
    }

    fun showErrorOrEmptyData() {
        errorLayout.visibility = View.VISIBLE
    }
}
