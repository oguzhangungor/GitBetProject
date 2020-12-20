package com.ogungor.tabprojecttest.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MatchModel(
    var homeTeam: String?,
    var awayTeam: String?,
    var bet: String?,
    var rate: String?,
    var oldRate: String?
) : Parcelable