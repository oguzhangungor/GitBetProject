package com.ogungor.tabprojecttest.feed.daily

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.network.model.MatchModel


class DailyFeedFragment : Fragment() , DailyFeedFragmentContract.View{

    private lateinit var dailyFeedFragmentPresenter: DailyFeedFragmentContract.Presenter
    private  lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DailyRecyclerAdapter
    private  var alert_text: TextView?=null




    override fun onAttach(context: Context) {
        super.onAttach(context)
        dailyFeedFragmentPresenter=DailyFeedFragmentPresenter().apply {
            setView(this@DailyFeedFragment)
            create()
            getDataFromFireStore()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_daily_feed, container, false)
        recyclerView= view.findViewById(R.id.daily_recycler_view)
        layoutManager= LinearLayoutManager(context)
        recyclerView.layoutManager= layoutManager
        adapter= DailyRecyclerAdapter(ArrayList<MatchModel>())
        recyclerView.adapter=adapter
        alert_text=view.findViewById(R.id.alert_message_text)
        alert_text?.isVisible=false


        return view
    }

    override fun initUi() {

    }

    override fun showAllMatches(model: java.util.ArrayList<MatchModel>) {
        adapter.setList(model)
    }
}