package com.ogungor.tabprojecttestlist.topten

import com.ogungor.tabprojecttestlist.network.ApiResponseListener
import com.ogungor.tabprojecttestlist.network.NetworkService
import com.ogungor.tabprojecttestlist.network.model.MatchModel
import com.ogungor.tabprojecttestlist.util.repo.FirebaseApi

class TopTenActivityPresenter : TopTenActivityContract.Presenter {

    private var view: TopTenActivityContract.View? = null
    private var networkService: NetworkService? = null



    override fun setView(view: TopTenActivityContract.View) {
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

        },"TopTen")

    }

    override fun itemSelect() {
        TODO("Not yet implemented")
    }
}