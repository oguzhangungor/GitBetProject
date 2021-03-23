package com.ogungor.gitbetproject.util.repo

import com.google.firebase.firestore.FirebaseFirestore
import com.ogungor.gitbetproject.network.ApiResponseListener
import com.ogungor.gitbetproject.network.NetworkService
import com.ogungor.gitbetproject.network.model.MatchModel
import kotlin.collections.ArrayList

class FirebaseApi : NetworkService {

    companion object {
        const val HOME_TEAM = "home_team"
        const val AWAY_TEAM = "away_team"
        const val BET = "bet"
        const val RATE = "rate"
        const val OLD_RATE = "old_rate"
        const val DATE = "date"
        const val LEAGUE = "league"
        const val START_TIME = "start_time"
        const val SKOR = "skor"
        const val RESULT = "result"
        const val COMMENT = "comment"
        const val PERCENT = "percent"
    }

    private val firebaseDB: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun getDashboardList(
        apiResponseListener: ApiResponseListener<ArrayList<MatchModel>>,
        tableName: String
    ) {
        var FirebaseApiTable = tableName
        firebaseDB.collection(FirebaseApiTable).addSnapshotListener { snaphot, exception ->
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
                                oldRate = document.getString(OLD_RATE),
                                date = document.getString(DATE),
                                leauge = document.getString(LEAGUE),
                                start_time = document.getString(START_TIME),
                                skor = document.getString(SKOR),
                                result = document.getString(RESULT),
                                comment = document.getString(COMMENT),
                                percent=document.getString(PERCENT)
                            )
                        )
                    }
                    apiResponseListener.onSuccess(matchList)
                } ?: apiResponseListener.onFail()
            }
        }
    }
}