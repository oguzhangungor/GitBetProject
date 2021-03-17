package com.ogungor.gitbetproject.feed.topten

import com.ogungor.gitbetproject.network.ApiResponseListener
import com.ogungor.gitbetproject.network.NetworkService
import com.ogungor.gitbetproject.network.model.MatchModel
import com.ogungor.gitbetproject.util.repo.FirebaseApi

class TopTenFeedFragmentPresenter : TopTenFeedFragmentContract.Presenter {
    private var view: TopTenFeedFragmentContract.View? = null
    private var networkService: NetworkService? = null

    override fun create() {
        networkService = FirebaseApi()
        view?.apply {
            initUi()
        }
    }

    override fun setView(view: TopTenFeedFragmentContract.View) {
        this.view = view
    }

    override fun destroy() {
    }

    override fun getDataFromFireStore() {
        networkService?.getDashboardList(object : ApiResponseListener<ArrayList<MatchModel>> {
            override fun onSuccess(model: ArrayList<MatchModel>) {
                if (model.isNotEmpty()) {
                    view?.run{
                        showAllMatches(model)
                        hideProgress()
                    }                }
            }
            override fun onFail() {
            }
        }, "TopTen")
    }
}