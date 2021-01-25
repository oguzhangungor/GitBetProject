package com.ogungor.tabprojecttestlist.feed.topten

import com.ogungor.tabprojecttestlist.network.model.MatchModel
import java.util.ArrayList

interface TopTenFeedFragmentContract {

    interface Presenter{

        fun create()

        fun setView(view: TopTenFeedFragmentContract.View)

        fun destroy()

        fun getDataFromFireStore()
    }

    interface View {

        fun initUi()

        fun showAllMatches(model: ArrayList<MatchModel>)
    }



}