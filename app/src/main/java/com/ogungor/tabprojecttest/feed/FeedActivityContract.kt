package com.ogungor.tabprojecttest.feed

import android.view.MenuItem
import android.widget.TextView
import com.google.firebase.firestore.DocumentSnapshot
import com.ogungor.tabprojecttest.network.model.MatchModel

interface FeedActivityContract {


    interface  Presenter{

        fun create()

        fun setView(view:View)

        fun getDataFromFireStore()

    }


    interface  View{

        fun initUi()

        fun showAllMatches(model: ArrayList<MatchModel>)

    }
}