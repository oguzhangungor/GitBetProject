package com.ogungor.tabprojecttestlist.util.extentions

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.ogungor.tabprojecttestlist.R
import com.ogungor.tabprojecttestlist.feed.daily.DailyFeedFragment
import com.ogungor.tabprojecttestlist.feed.profile.ProfileFragment
import com.ogungor.tabprojecttestlist.feed.result.ResultFeedFragment
import com.ogungor.tabprojecttestlist.feed.topten.TopTenFeedFragment

enum class FeedScreen(@IdRes val menuItemId: Int,
                      val fragment: Fragment
) {
    HOME(R.id.navigator_home,DailyFeedFragment()),
    TOPTEN(R.id.navigator_topten,TopTenFeedFragment()),
    RESULT(R.id.navigator_result,ResultFeedFragment()),
    PROFILE(R.id.navigator_profile,ProfileFragment())
}

fun getMainScreenForMenuItem(menuItemId: Int): FeedScreen? {
    for (feedScreen in FeedScreen.values()) {
        if (feedScreen.menuItemId == menuItemId) {
            return feedScreen
        }
    }
    return null
}