package com.ogungor.gitbetproject.feed.daily

import com.ogungor.gitbetproject.network.model.MatchModel
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