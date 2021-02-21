package com.ogungor.gitbetproject.feed.daily

import com.ogungor.gitbetproject.network.ApiResponseListener
import com.ogungor.gitbetproject.network.NetworkService
import com.ogungor.gitbetproject.network.model.MatchModel
import com.ogungor.gitbetproject.util.repo.FirebaseApi

class DailyFeedFragmentPresenter : DailyFeedFragmentContract.Presenter {

    private var view: DailyFeedFragmentContract.View?=null
    private var networkService: NetworkService? = null

    override fun create() {
        networkService = FirebaseApi()
        view?.apply {
            initUi()
        }
        getDataFromFireStore()
    }

    override fun setView(view: DailyFeedFragmentContract.View) {
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
        },"MatchBets")
    }
}