package com.ogungor.tabprojecttest.feed

import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.ogungor.tabprojecttest.R

class FeedActivityPresenter : FeedActivityContract.Presenter {

    private lateinit var view: FeedActivityContract.View
    private var auth: FirebaseAuth? = null
    private lateinit var firebaseDB:FirebaseFirestore

    /*private lateinit var adapter: FeedRecyclerAdapter

    var matchFromFB: ArrayList<String> =ArrayList()
    var betFromFB: ArrayList<String> =ArrayList()
    var rateFromFB: ArrayList<String> =ArrayList()
    var oldRateFromFB: ArrayList<String> =ArrayList()

     */

    override fun create() {
        auth = FirebaseAuth.getInstance()
        //adapter= FeedRecyclerAdapter(matchFromFB,betFromFB,rateFromFB)
        view.apply {
            initUi()
        }
    }

    override fun menuItemSelected(item: MenuItem) {
        if (item.itemId == R.id.logout) {
            auth?.signOut()
            view.run {
                showSignOutMessage()
                intentToMainActivity()
            }
        }
    }

    override fun setView(view: FeedActivityContract.View) {
        this.view = view
    }

    override fun getDataFromFirestore() {

        firebaseDB= FirebaseFirestore.getInstance()

        firebaseDB.collection("MatchBets").addSnapshotListener { snaphot, exception ->
                if (exception !=null)
                {
                    view.showSignOutMessage()
                }else {

                    if(snaphot!=null)
                    {
                        if (!snaphot.isEmpty)
                        {
                            val documents= snaphot.documents
                            var i =1
                            for (document in documents)
                            {
                                view.run {
                                    getDB(document)
                                    showAllDocumentMessage(i)
                                }
                                i++
                            }
                        }
                    }
                }

        }
    }

    override fun documentControl(m: String, b: String) {
        if (m==null)
        {
            view.showDocumentMessage()
        }
        else if (b==null){
            view.showNoDocumentMessage()
         }
        else {

        }
    }
}