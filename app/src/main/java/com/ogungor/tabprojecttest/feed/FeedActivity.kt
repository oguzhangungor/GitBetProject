package com.ogungor.tabprojecttest.feed

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.activity.BaseActivity

class FeedActivity : BaseActivity(), FeedActivityContract.View,
    BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var feedActivityPresenter: FeedActivityContract.Presenter
    private lateinit var sectionsPagerFeedAdapter: SectionsPagerFeedAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabs: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        feedActivityPresenter = FeedActivityPresenter().apply {
            setView(this@FeedActivity)
            create()

        }
    }


    override fun getLayout(): Int = R.layout.activity_feed

    override fun initUi() {

        sectionsPagerFeedAdapter = SectionsPagerFeedAdapter(supportFragmentManager)
        viewPager = findViewById(R.id.view_pager_feed)
        viewPager.adapter = sectionsPagerFeedAdapter
        tabs = findViewById(R.id.bottom_navigation_bar)
        tabs.setOnNavigationItemSelectedListener(this)
        sectionsPagerFeedAdapter.setItems(
            arrayListOf(
                FeedScreen.HOME,
                FeedScreen.TOPTEN,
                FeedScreen.RESULT
            )
        )

        val defaultScreen = FeedScreen.HOME
        scrollToFragment(defaultScreen)
        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
        supportActionBar?.setTitle(defaultScreen.titleStringId)

        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                val selectedFragment = sectionsPagerFeedAdapter.getItems()[position]
                selectBottomNavigationViewMenuItem(selectedFragment.menuItemId)
                supportActionBar?.setTitle(selectedFragment.titleStringId)

            }
        })
    }

    private fun setItemClickRecycler() {
        feedActivityPresenter.itemSelect()
    }

    private fun scrollToFragment(mainScreen: FeedScreen) {
        val fragmentPosition = sectionsPagerFeedAdapter.getItems().indexOf(mainScreen)
        if (fragmentPosition != viewPager.currentItem) {
            viewPager.currentItem = fragmentPosition
        }
    }

    private fun selectBottomNavigationViewMenuItem(@IdRes menuItemId: Int) {
        tabs.setOnNavigationItemSelectedListener(null)
        tabs.selectedItemId = menuItemId
        tabs.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        getMainScreenForMenuItem(menuItem.itemId)?.let {
            scrollToFragment(it)
            supportActionBar?.setTitle(it.titleStringId)
            return true
        }
        return false
    }

}