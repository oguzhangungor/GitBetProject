package com.ogungor.tabprojecttest.topten

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.activity.BaseActivity
import com.ogungor.tabprojecttest.network.model.MatchModel

class TopTenActivityFragment : BaseActivity(), TopTenActivityContract.View {

    private lateinit var feedActivityPresenter: TopTenActivityContract.Presenter
    private  lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter: ToptenRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        feedActivityPresenter = TopTenActivityPresenter().apply {
            setView(this@TopTenActivityFragment)
            create()
            getDataFromFireStore()
        }
    }


    override fun getLayout(): Int = R.layout.activity_feed

    override fun initUi() {

        recyclerView= findViewById(R.id.feed_recycler_view)
        layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager= layoutManager
        adapter= ToptenRecyclerAdapter(ArrayList<MatchModel>())
        recyclerView.adapter=adapter

        recyclerView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                setItemClickRecycler()
            }

        })


    }

    private fun setItemClickRecycler() {
        feedActivityPresenter.itemSelect()
    }

    override fun showAllMatches(model: java.util.ArrayList<MatchModel>) {
        adapter.setList(model)
    }

}