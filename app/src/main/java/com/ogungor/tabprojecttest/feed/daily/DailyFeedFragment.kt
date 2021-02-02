package com.ogungor.tabprojecttest.feed.daily

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.feed.FeedActivity
import com.ogungor.tabprojecttest.feed.daily.commentdialog.CommentDialogFragment
import com.ogungor.tabprojecttest.network.model.MatchModel


class DailyFeedFragment : Fragment() , DailyFeedFragmentContract.View, DailyRecyclerAdapter.OnItemClickListener{

    private lateinit var feedActivity: FeedActivity
    private lateinit var dailyFeedFragmentPresenter: DailyFeedFragmentContract.Presenter
    private  lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DailyRecyclerAdapter




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
        adapter= DailyRecyclerAdapter(ArrayList<MatchModel>(),this)
        recyclerView.adapter=adapter



        return view
    }

    override fun initUi() {

    }

    override fun showAllMatches(model: java.util.ArrayList<MatchModel>) {
        adapter.setList(model)
    }

    override fun onItemClick(position: Int,commentList:ArrayList<String>,teamList:ArrayList<String>) {
        var fm=fragmentManager
        var fragment=
            CommentDialogFragment(commentList[position],teamList[position])
        if (fm != null) {
            fragment.show(fm,"dede")
        }
    }
}