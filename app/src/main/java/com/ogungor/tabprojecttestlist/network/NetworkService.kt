package com.ogungor.tabprojecttestlist.network

import com.ogungor.tabprojecttestlist.network.model.MatchModel

interface NetworkService {

    fun getDashboardList(apiResponseListener: ApiResponseListener<ArrayList<MatchModel>>, tableName:String)

}