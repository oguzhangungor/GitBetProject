package com.ogungor.gitbetproject.feed.topten

import com.ogungor.gitbetproject.network.model.MatchModel
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