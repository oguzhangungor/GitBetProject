package com.ogungor.gitbetproject.feed.daily

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.gitbetproject.R
import com.ogungor.gitbetproject.network.model.MatchModel

class DailyRecyclerAdapter(private var matchList: ArrayList<MatchModel>,
                           private var listener: OnItemClickListener) :
    RecyclerView.Adapter<DailyRecyclerAdapter.BetHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BetHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_view_daily_row, parent, false)
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
            currentMatch.newRate?.let {

                var controlCodeState = oldRateControl(it, textViewRate.text.toString())
                if (controlCodeState == 1) {
                    newRateViewIcon.setImageResource(R.drawable.upicon)
                    textViewRate.text = it
                } else if (controlCodeState == 0) {
                    newRateViewIcon.setImageResource(R.drawable.downicon)
                    textViewRate.text = it
                }
            }
            currentMatch.leauge.let {
                textViewLeague.text = it
            }
            currentMatch.date.let {
                textViewDate.text = it
            }
            currentMatch.start_time.let {
                textViewStartTime.text = it
            }

            currentMatch.comment.let {
                if(it!=="")
                {
                    commentButton.setImageResource(R.drawable.comment_icon)
                }
                else{
                    commentButton.setImageResource(R.drawable.white_comment)
                    commentButton.isEnabled=false

                }
            }

            commentButton.setOnClickListener {
                listener.onItemClick(currentMatch)
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

    inner class BetHolder(view: View) : RecyclerView.ViewHolder(view) {
        var commentButton:ImageButton=view.findViewById(R.id.comment_button)
        var textViewMatch: TextView = view.findViewById(R.id.match_text)
        var textViewBet: TextView = view.findViewById(R.id.bet_text)
        var textViewRate: TextView = view.findViewById(R.id.rate_text)
        var textViewLeague: TextView = view.findViewById(R.id.league_text)
        var textViewDate: TextView = view.findViewById(R.id.date_text)
        var textViewStartTime: TextView = view.findViewById(R.id.start_time_text)
        var newRateViewIcon: ImageView = view.findViewById(R.id.old_rate_icon)
         }
    interface OnItemClickListener {
        fun onItemClick(model: MatchModel)
    }

    fun strParseInt(str: String): Double {
        var parseInt = str.toDouble()
        return parseInt
    }

    fun oldRateControl(oldRate: String, rate: String): Int {
        var controlCode: Int
        if (oldRate !== "") {
            var newRateControl = strParseInt(oldRate)
            var rateControl = strParseInt(rate)
            controlCode = if (newRateControl > rateControl) {
                1
            } else {
                0
            }
            return controlCode
        }
        return 2
    }
}