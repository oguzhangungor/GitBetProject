package com.ogungor.tabprojecttest.feed.daily

import com.ogungor.tabprojecttest.network.model.MatchModel
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