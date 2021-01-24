package com.ogungor.tabprojecttest.feed.result

import com.ogungor.tabprojecttest.network.ApiResponseListener
import com.ogungor.tabprojecttest.network.NetworkService
import com.ogungor.tabprojecttest.network.model.MatchModel
import com.ogungor.tabprojecttest.util.repo.FirebaseApi

class ResultFeedFragmentPresenter : ResultFeedFragmentContract.Presenter{
        private var view: ResultFeedFragmentContract.View?=null
        private var networkService: NetworkService? = null

    override fun create() {
        networkService=FirebaseApi()
        view?.apply {
            initUi()
        }
    }

    override fun setView(view: ResultFeedFragmentContract.View) {
        this.view=view
    }

    override fun destroy() {
        view=null
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

        }, "Result")

    }
}