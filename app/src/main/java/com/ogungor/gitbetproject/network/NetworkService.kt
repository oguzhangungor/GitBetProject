package com.ogungor.gitbetproject.network

import com.ogungor.gitbetproject.network.model.MatchModel

interface NetworkService {

    fun getDashboardList(apiResponseListener: ApiResponseListener<ArrayList<MatchModel>>, tableName:String)

}