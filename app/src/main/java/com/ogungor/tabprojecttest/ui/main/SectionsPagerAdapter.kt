package com.ogungor.tabprojecttest.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.ui.main.createFragment.CreateUserFragment
import com.ogungor.tabprojecttest.ui.main.loginFragment.LoginUserFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_login_user,
    R.string.tab_create_user,
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = LoginUserFragment()
            }
            1 -> {
                fragment = CreateUserFragment()
            }
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}