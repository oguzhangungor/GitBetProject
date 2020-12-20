package com.ogungor.tabprojecttest.feed

import android.view.MenuItem
import android.widget.TextView
import com.google.firebase.firestore.DocumentSnapshot
import com.ogungor.tabprojecttest.network.model.MatchModel

interface FeedActivityContract {


    interface  Presenter{

        fun create()

        fun setView(view:View)

        fun menuItemSelected(item: MenuItem)

        fun getDataFromFirestore()

    }


    interface  View{

        fun initUi()

        fun showSignOutMessage()

        fun intentToMainActivity()

        fun showAllMatches(model: ArrayList<MatchModel>)

    }
}