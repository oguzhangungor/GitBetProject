package com.ogungor.gitbetproject.feed.topten

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.ogungor.gitbetproject.R
import com.ogungor.gitbetproject.network.model.MatchModel


class TopTenFeedFragment : Fragment(),TopTenFeedFragmentContract.View {
    private lateinit var topTenFeedFragmentPresenter: TopTenFeedFragmentContract.Presenter
    private  lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TopTenRecyclerAdapter
    private  var alertText:TextView?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        topTenFeedFragmentPresenter= TopTenFeedFragmentPresenter().apply {
            setView(this@TopTenFeedFragment)
            create()
            getDataFromFireStore()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_top_ten_feed, container, false)
        recyclerView= view.findViewById(R.id.topten_recycler_view)
        layoutManager= LinearLayoutManager(context)
        recyclerView.layoutManager= layoutManager
        adapter= TopTenRecyclerAdapter(ArrayList<MatchModel>())
        recyclerView.adapter=adapter
        alertText=view.findViewById(R.id.update_message_text)
        alertText?.text=getString(R.string.topten_update_text)
        return view
    }

    override fun initUi() {
    }


    override fun showAllMatches(model: java.util.ArrayList<MatchModel>) {
        adapter.setList(model)
    }
}