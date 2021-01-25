package com.ogungor.tabprojecttestlist.feed.daily

import com.ogungor.tabprojecttestlist.network.model.MatchModel
import java.util.ArrayList

interface DailyFeedFragmentContract {

    interface Presenter{

        fun create()

        fun setView(view:DailyFeedFragmentContract.View)

        fun destroy()

        fun getDataFromFireStore()
    }

    interface View {

        fun initUi()

        fun showAllMatches(model: ArrayList<MatchModel>)
    }



}