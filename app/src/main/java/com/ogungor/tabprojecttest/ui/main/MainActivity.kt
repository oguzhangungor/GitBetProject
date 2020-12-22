package com.ogungor.tabprojecttest.ui.main


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.activity.BaseActivity
import com.ogungor.tabprojecttest.util.extentions.launchFeedsActivity
import com.ogungor.tabprojecttest.util.extentions.showShortToast

class MainActivity : BaseActivity(), MainActivityContract.View {

    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout
    private lateinit var mainActivityPresenter: MainActivityContract.Presenter
    private lateinit var auth:FirebaseAuth
    private var currentUser:FirebaseUser?=null
    private lateinit var sharedPrefGet:SharedPreferences
    private var booleen:Boolean=true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityPresenter = MainActivityPresenter()
            .apply {
                setView(this@MainActivity)
                create()
                loginUserControl(currentUser,booleen)
            }
    }

    override fun getLayout(): Int = R.layout.activity_main

    override fun initUi() {
        auth= FirebaseAuth.getInstance()
        currentUser= auth.currentUser
        sharedPrefGet=getSharedPreferences(R.string.preference_file_key.toString(),0)
        booleen=sharedPrefGet.getBoolean("checked",false)
        sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        tabs = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }

    override fun intentToFeedsActivity() {
        launchFeedsActivity()
        finish()
    }

    override fun showLoginMessage() {
        showShortToast(getString(R.string.welcome)+" ${auth.currentUser?.email.toString()}")
    }
}