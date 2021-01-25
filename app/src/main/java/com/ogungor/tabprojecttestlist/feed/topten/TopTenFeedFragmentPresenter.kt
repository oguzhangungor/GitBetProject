package com.ogungor.tabprojecttestlist.feed.topten

import com.ogungor.tabprojecttestlist.network.ApiResponseListener
import com.ogungor.tabprojecttestlist.network.NetworkService
import com.ogungor.tabprojecttestlist.network.model.MatchModel
import com.ogungor.tabprojecttestlist.util.repo.FirebaseApi

class TopTenFeedFragmentPresenter : TopTenFeedFragmentContract.Presenter {
    private var view: TopTenFeedFragmentContract.View?=null
    private var networkService: NetworkService? = null


    override fun create() {
        networkService = FirebaseApi()
        view?.apply {
            initUi()
        }
    }

    override fun setView(view: TopTenFeedFragmentContract.View) {
        this.view=view
    }

    override fun destroy() {

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

        }, "TopTen")

    }
}