package com.ogungor.gitbetproject.feed.result

import com.ogungor.gitbetproject.network.ApiResponseListener
import com.ogungor.gitbetproject.network.NetworkService
import com.ogungor.gitbetproject.network.model.MatchModel
import com.ogungor.gitbetproject.util.repo.FirebaseApi

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