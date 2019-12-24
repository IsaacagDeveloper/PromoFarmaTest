package com.isaacdeveloper.promofarmatest.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.isaacdeveloper.promofarmatest.R

fun ImageView.loadImageFromURL(context: Context, url: String) {
    val options = RequestOptions()
        .centerInside()
        .error(R.drawable.no_poster_avaliable)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)

    Glide.with(context)
        .load(url)
        .apply(options)
        .into(this)

}