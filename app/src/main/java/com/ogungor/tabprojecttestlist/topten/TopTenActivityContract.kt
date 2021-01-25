package com.ogungor.tabprojecttestlist.topten

import com.ogungor.tabprojecttestlist.network.model.MatchModel

interface TopTenActivityContract {


    interface  Presenter{

        fun create()

        fun setView(view:View)

        fun getDataFromFireStore()

        fun itemSelect()

    }


    interface  View{

        fun initUi()

        fun showAllMatches(model: ArrayList<MatchModel>)

    }
}