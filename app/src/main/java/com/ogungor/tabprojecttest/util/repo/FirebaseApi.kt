package com.ogungor.tabprojecttest.util.repo

import com.google.firebase.firestore.FirebaseFirestore
import com.ogungor.tabprojecttest.network.ApiResponseListener
import com.ogungor.tabprojecttest.network.NetworkService
import com.ogungor.tabprojecttest.network.model.MatchModel

class FirebaseApi : NetworkService {

    companion object {
        const val MATCH_BETS = "MatchBets"
        const val HOME_TEAM = "home_team"
        const val AWAY_TEAM = "away_team"
        const val BET = "bet"
        const val RATE = "rate"
        const val OLD_RATE = "old_rate"

    }

    private val firebaseDB: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun getDashboardList(apiResponseListener: ApiResponseListener<ArrayList<MatchModel>>) {
        firebaseDB.collection(MATCH_BETS).addSnapshotListener { snaphot, exception ->

            if (exception != null) {
                apiResponseListener.onFail()
            } else {
                snaphot?.documents?.let {
                    val matchList = ArrayList<MatchModel>()
                    for (document in it) {
                        matchList.add(
                            MatchModel(
                                homeTeam = document.getString(HOME_TEAM),
                                awayTeam = document.getString(AWAY_TEAM),
                                bet = document.getString(BET),
                                rate = document.getString(RATE),
                                oldRate = document.getString(OLD_RATE)
                            )
                        )
                    }
                    apiResponseListener.onSuccess(matchList)
                } ?: apiResponseListener.onFail()
            }
        }
    }

}