package com.ogungor.tabprojecttestlist.feed

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ogungor.tabprojecttestlist.util.extentions.FeedScreen

class SectionsPagerFeedAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragments = arrayListOf<FeedScreen>()

    fun setItems(fragment: List<FeedScreen>) {
        this.fragments.apply {
            clear()
            addAll(fragment)
            notifyDataSetChanged()
        }
    }

    fun getItems(): List<FeedScreen> {
        return fragments
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position].fragment
    }

    override fun getCount(): Int {
        return fragments.size
    }
}