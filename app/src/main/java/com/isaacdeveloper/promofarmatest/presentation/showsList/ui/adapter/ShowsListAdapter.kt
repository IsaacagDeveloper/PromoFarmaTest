package com.isaacdeveloper.promofarmatest.presentation.showsList.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isaacdeveloper.promofarmatest.R
import com.isaacdeveloper.promofarmatest.domain.model.ShowsListDomainModel
import com.isaacdeveloper.promofarmatest.utils.loadImageFromURL
import kotlinx.android.synthetic.main.item_show.view.*

class ShowsListAdapter(val context: Context,
                       var showsList: MutableList<ShowsListDomainModel>,
                       val onClickListItem: (ShowsListDomainModel) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class ShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgShow = view.imgShow
        val txtShow = view.txtShowName

        fun onbind(item : ShowsListDomainModel){
            imgShow.loadImageFromURL(context, item.url)
            txtShow.text = item.name
            itemView.setOnClickListener { onClickListItem(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        viewHolder = ShowViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_show, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val showsListDomainModel = showsList[position]
        val viewHolder = holder as ShowViewHolder
        viewHolder.onbind(showsListDomainModel)
    }

    override fun getItemCount(): Int {
        return showsList.size
    }

    internal fun clear() {
        this.showsList = mutableListOf()
    }

    internal fun addAll(showsSend: List<ShowsListDomainModel>) {
        this.showsList.addAll(showsSend)
    }
}