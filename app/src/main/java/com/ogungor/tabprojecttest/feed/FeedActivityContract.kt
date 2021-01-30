package com.ogungor.tabprojecttest.feed

import android.view.MenuItem
import android.widget.TextView
import com.google.firebase.firestore.DocumentSnapshot
import com.ogungor.tabprojecttest.network.model.MatchModel

interface FeedActivityContract {


    interface  Presenter{

        fun create()

        fun setView(view:FeedActivityContract.View)

        fun itemSelect()

        fun destroy ()

    }


    interface  View{

        fun initUi()



    }
}