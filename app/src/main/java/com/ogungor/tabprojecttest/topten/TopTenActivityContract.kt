package com.ogungor.tabprojecttest.topten

import android.view.MenuItem
import android.widget.TextView
import com.google.firebase.firestore.DocumentSnapshot
import com.ogungor.tabprojecttest.network.model.MatchModel

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