package com.isaacdeveloper.promofarmatest.presentation.showDetail.ui.activity

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.isaacdeveloper.promofarmatest.R
import com.isaacdeveloper.promofarmatest.kernel.ui.BaseActivity
import com.isaacdeveloper.promofarmatest.presentation.showDetail.ui.fragment.ShowDetailFragment
import com.isaacdeveloper.promofarmatest.utils.loadImageFromURL
import kotlinx.android.synthetic.main.activity_with_transparent_toolbar.*

class ShowDetailActivity : BaseActivity() {

    companion object {
        const val SHOW_ID_SEND = "SHOW_ID_SEND"
        const val SHOW_TITLE_SEND = "SHOW_TITLE_SEND"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_transparent_toolbar)
        configureActionBar()
        if (savedInstanceState == null) {
            intent.extras?.getString(SHOW_ID_SEND)?.also { id -> String
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ShowDetailFragment.newInstance(id), ShowDetailFragment::class.java.name)
                    .commit()
            }
        }
    }

    private fun configureActionBar() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.transparent)
        setSupportActionBar(parallaxToolbar)
        showToolbarWithBackButton()
        supportActionBar?.let {
            intent.extras?.getString(SHOW_TITLE_SEND)?.also {showTitle -> String
                title = showTitle
            }
        }
    }

    fun setParallaxImage(url: String) {
        imgParallaxToolbar.loadImageFromURL(this, url)
    }

    fun showLoading() {
        progressBarShowDetail.visibility = View.VISIBLE
    }

    fun hideLoading() {
        progressBarShowDetail.visibility = View.GONE
    }
}