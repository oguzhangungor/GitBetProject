package com.ogungor.tabprojecttest.feed

import android.view.MenuItem
import android.widget.TextView
import com.google.firebase.firestore.DocumentSnapshot

interface FeedActivityContract {


    interface  Presenter{

        fun create()

        fun setView(view:View)

        fun menuItemSelected(item: MenuItem)

        fun getDataFromFirestore()

        fun documentControl(m: String,b:String)
    }


    interface  View{

        fun initUi()

        fun showSignOutMessage()

        fun intentToMainActivity()

        fun getDB(document : DocumentSnapshot)

        fun showDocumentMessage()

        fun showNoDocumentMessage()

       fun showAllDocumentMessage(i : Int)

    }
}