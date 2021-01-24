package com.ogungor.tabprojecttest.feed.topten

import com.ogungor.tabprojecttest.network.model.MatchModel
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