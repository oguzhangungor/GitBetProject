package com.ogungor.tabprojecttest.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.activity.BaseActivity
import com.ogungor.tabprojecttest.util.extentions.launchMainToLoginSignUpActivity
import com.ogungor.tabprojecttest.util.extentions.showShortToast

class MainActivity : BaseActivity(), MainActivityContract.View {
    private lateinit var mainActivityPresenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityPresenter = MainActivityPresenter().apply {
            setView(this@MainActivity)
            create()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.feed_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        mainActivityPresenter.menuItemSelected(item)
        return super.onOptionsItemSelected(item)
    }


    override fun getLayout(): Int = R.layout.activity_main


    override fun initUi() {


    }

    override fun showSignOutMessage() {
        showShortToast(getString(R.string.log_out))
    }

    override fun intentToLoginSignUpActivity() {
        launchMainToLoginSignUpActivity()
        finish()
    }
}