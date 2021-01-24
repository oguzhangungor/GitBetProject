package com.ogungor.tabprojecttest.feed

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.feed.daily.DailyFeedFragment
import com.ogungor.tabprojecttest.feed.result.ResultFeedFragment
import com.ogungor.tabprojecttest.feed.topten.TopTenFeedFragment

enum class FeedScreen(@IdRes val menuItemId: Int,
                      @DrawableRes val menuItemIconId: Int,
                      @StringRes val titleStringId: Int,
                      val fragment: Fragment
) {
    HOME(R.id.navigator_home, R.drawable.homeactive ,R.string.navigator_menu_home, DailyFeedFragment()),
    TOPTEN(R.id.navigator_topten, R.drawable.toptenactive, R.string.navigator_menu_topten, TopTenFeedFragment()),
    RESULT(R.id.navigator_before, R.drawable.beforeactive, R.string.navigator_menu_results, ResultFeedFragment())
   // PROFILE(R.id.bottom_navigation_item_profile, R.drawable.ic_profile, R.string.activity_main_bottom_screen_profile, ProfileFragment())
}

fun getMainScreenForMenuItem(menuItemId: Int): FeedScreen? {
    for (feedScreen in FeedScreen.values()) {
        if (feedScreen.menuItemId == menuItemId) {
            return feedScreen
        }
    }
    return null
}