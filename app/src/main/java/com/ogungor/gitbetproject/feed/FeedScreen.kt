package com.ogungor.gitbetproject.feed

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.ogungor.gitbetproject.R
import com.ogungor.gitbetproject.feed.daily.DailyFeedFragment
import com.ogungor.gitbetproject.feed.profile.ProfileFragment
import com.ogungor.gitbetproject.feed.result.ResultFeedFragment
import com.ogungor.gitbetproject.feed.topten.TopTenFeedFragment

enum class FeedScreen(@IdRes val menuItemId: Int,

                      val fragment: Fragment
) {
    HOME(R.id.navigator_home,  DailyFeedFragment()),
    TOPTEN(R.id.navigator_topten, TopTenFeedFragment()),
    RESULT(R.id.navigator_result, ResultFeedFragment()),
   PROFILE(R.id.navigator_profile, ProfileFragment())
}

fun getMainScreenForMenuItem(menuItemId: Int): FeedScreen? {
    for (feedScreen in FeedScreen.values()) {
        if (feedScreen.menuItemId == menuItemId) {
            return feedScreen
        }
    }
    return null
}