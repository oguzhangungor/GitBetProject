package com.ogungor.tabprojecttest.feed

import android.content.SharedPreferences
import android.util.Log.e
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.network.ApiResponseListener
import com.ogungor.tabprojecttest.network.NetworkService
import com.ogungor.tabprojecttest.network.model.MatchModel
import com.ogungor.tabprojecttest.util.repo.FirebaseApi

class FeedActivityPresenter : FeedActivityContract.Presenter {

    private var view: FeedActivityContract.View? = null
    private var networkService: NetworkService? = null



    override fun setView(view: FeedActivityContract.View) {
        this.view = view
    }

    override fun create() {
        networkService = FirebaseApi()
        view?.apply {
            initUi()
        }
    }



    override fun getDataFromFireStore() {
        networkService?.getDashboardList(object : ApiResponseListener<ArrayList<MatchModel>> {
            override fun onSuccess(model: ArrayList<MatchModel>) {
                if (model.isNotEmpty()) {
                    view?.showAllMatches(model)
                }
            }

            override fun onFail() {
            }

        })

    }

    override fun itemSelect() {
        TODO("Not yet implemented")
    }
}