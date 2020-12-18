package com.ogungor.tabprojecttest.feed

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.tabprojecttest.R

class FeedRecyclerAdapter(private val matchFromFB: ArrayList<String>,private val betFromFB: ArrayList<String>,private val rateFromFB: ArrayList<String> ) : RecyclerView.Adapter<FeedRecyclerAdapter.BetHolder>() {

    class BetHolder(view :View) : RecyclerView.ViewHolder(view) {

        var match_text: TextView?=null
        var bet_text: TextView?=null
        var rate_text: TextView?=null
        init {
            match_text=view.findViewById(R.id.match_text)
            bet_text=view.findViewById(R.id.bet_text)
            rate_text=view.findViewById(R.id.rate_text)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BetHolder {
        var inflater= LayoutInflater.from(parent.context)
        var view_bet=inflater.inflate(R.layout.recycler_view_row,parent,false)
        return BetHolder(view_bet)
    }

    override fun onBindViewHolder(holder: BetHolder, position: Int) {
        holder.match_text?.text= matchFromFB[position]
        holder.bet_text?.text= betFromFB[position]
        holder.rate_text?.text= rateFromFB[position]

    }

    override fun getItemCount(): Int {
        return matchFromFB.size
    }


}