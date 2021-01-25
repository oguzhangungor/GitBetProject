package com.ogungor.tabprojecttestlist.loginsignup

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ogungor.tabprojecttestlist.R
import com.ogungor.tabprojecttestlist.loginsignup.signUpFragment.SignUpUserFragment
import com.ogungor.tabprojecttestlist.loginsignup.loginFragment.LoginUserFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_login_user,
    R.string.tab_signup_user,
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
                fragment = SignUpUserFragment()
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