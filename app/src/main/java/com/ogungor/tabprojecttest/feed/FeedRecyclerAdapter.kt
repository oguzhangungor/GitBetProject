package com.ogungor.tabprojecttest.feed

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.network.model.MatchModel

class FeedRecyclerAdapter(private var matchList: ArrayList<MatchModel> ) : RecyclerView.Adapter<FeedRecyclerAdapter.BetHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BetHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.recycler_view_row,parent,false)
        return BetHolder(view)
    }

    override fun onBindViewHolder(holder: BetHolder, position: Int) {
        val currentMatch = matchList[position]
        holder.run {
            currentMatch.homeTeam?.let {
                textViewMatch.text= "$it - ${currentMatch.awayTeam}"
            }
            currentMatch.bet?.let {
                textViewBet.text=it + "  ${currentMatch.rate}"
            }
            currentMatch.oldRate?.let {
            }
            currentMatch.leauge.let {
                textViewLeague.text=it

            }
            currentMatch.date.let{
                textViewDate.text=it
            }
        }

    }

    override fun getItemCount(): Int {
        return matchList.size
    }

    fun setList(list: ArrayList<MatchModel>){
        matchList = list
        notifyDataSetChanged()
    }

    class BetHolder(view :View) : RecyclerView.ViewHolder(view) {
        var textViewMatch: TextView = view.findViewById(R.id.match_text)
        var textViewBet: TextView = view.findViewById(R.id.bet_rate_text)
        var textViewLeague:TextView=view.findViewById(R.id.league_text)
        var textViewDate:TextView=view.findViewById(R.id.date_text)
    }
}