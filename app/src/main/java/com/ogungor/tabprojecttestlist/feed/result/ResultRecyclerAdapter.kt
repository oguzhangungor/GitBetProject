package com.ogungor.tabprojecttestlist.feed.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.tabprojecttestlist.R
import com.ogungor.tabprojecttestlist.network.model.MatchModel

class ResultRecyclerAdapter(private var matchList: ArrayList<MatchModel>) :
    RecyclerView.Adapter<ResultRecyclerAdapter.BetHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BetHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_view_row, parent, false)
        return BetHolder(view)
    }

    override fun onBindViewHolder(holder: BetHolder, position: Int) {
        val currentMatch = matchList[position]
        holder.run {
            currentMatch.homeTeam?.let {
                textViewMatch.text = "$it - ${currentMatch.awayTeam}"
            }
            currentMatch.bet?.let {
                textViewBet.text = it
            }
            currentMatch.rate?.let {
                textViewRate.text = it
            }
            currentMatch.leauge.let {
                textViewLeague.text = it
            }
            currentMatch.date.let {
                textViewDate.text = it
                           }

        }

    }


    override fun getItemCount(): Int {
        return matchList.size
    }

    fun setList(list: ArrayList<MatchModel>) {
        matchList = list
        notifyDataSetChanged()
    }

    class BetHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewMatch: TextView = view.findViewById(R.id.match_text)
        var textViewBet: TextView = view.findViewById(R.id.bet_text)
        var textViewRate: TextView = view.findViewById(R.id.rate_text)
        var textViewLeague: TextView = view.findViewById(R.id.league_text)
        var textViewDate: TextView = view.findViewById(R.id.date_text)
    }

    fun strParseInt(str: String): Double {

        var parseInt = str.toDouble()

        return parseInt
    }

    fun oldRateControl(oldRate: String, rate: String): Int {

        var controlCode: Int

        if (oldRate !== "") {
            var oldRateControl = strParseInt(oldRate)
            var rateControl = strParseInt(rate)
            controlCode = if (oldRateControl > rateControl) {
                1
            } else {
                0
            }
            return controlCode
        }
        return 2

    }


}