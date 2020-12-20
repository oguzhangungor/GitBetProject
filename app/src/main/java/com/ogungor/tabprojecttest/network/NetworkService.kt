package com.ogungor.tabprojecttest.network

import com.ogungor.tabprojecttest.network.model.MatchModel

interface NetworkService {

    fun getDashboardList(apiResponseListener: ApiResponseListener<ArrayList<MatchModel>>)

}