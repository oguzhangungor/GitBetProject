package com.ogungor.gitbetproject.feed.result

import com.ogungor.gitbetproject.network.model.MatchModel
import java.util.ArrayList

interface ResultFeedFragmentContract {

    interface Presenter {

        fun create()

        fun setView(view:ResultFeedFragmentContract.View)

        fun destroy()

        fun getDataFromFireStore()
    }

    interface View{

        fun initUi()

        fun showAllMatches(model: ArrayList<MatchModel>)
    }
}