package com.ogungor.gitbetproject.loginsignup


import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.ogungor.gitbetproject.R
import com.ogungor.gitbetproject.activity.BaseActivity
import com.ogungor.gitbetproject.util.extentions.launchMainToFeedActivity

import com.ogungor.gitbetproject.util.extentions.showShortToast

class LoginSignUpActivity : BaseActivity(), LoginSignUpActivityContract.View {

    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout
    private lateinit var mainActivityPresenter: LoginSignUpActivityContract.Presenter
    private lateinit var auth:FirebaseAuth
    private var currentUser:FirebaseUser?=null
    private lateinit var sharedPrefGet:SharedPreferences
    private var booleen:Boolean=true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityPresenter = LoginSignUpActivityPresenter()
            .apply {
                setView(this@LoginSignUpActivity)
                create()
                loginUserControl(currentUser,booleen)
            }
    }

    override fun getLayout(): Int = R.layout.activity_login_signup

    override fun initUi() {
        auth= FirebaseAuth.getInstance()
        currentUser= auth.currentUser
        sharedPrefGet=getSharedPreferences(R.string.preference_file_key.toString(), 0)
        booleen=sharedPrefGet.getBoolean("checked",false)
        sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        viewPager = findViewById(R.id.view_pager_login)
        viewPager.adapter = sectionsPagerAdapter
        tabs = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }

    override fun intentToaMainActivity() {
        launchMainToFeedActivity()
        finish()
    }

    override fun showLoginMessage() {
        showShortToast(getString(R.string.welcome)+" ${auth.currentUser?.email.toString()}")
    }


}