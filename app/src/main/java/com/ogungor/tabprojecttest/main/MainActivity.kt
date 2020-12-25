package com.ogungor.tabprojecttest.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.activity.BaseActivity
import com.ogungor.tabprojecttest.util.extentions.launchMainToFeedsActivity
import com.ogungor.tabprojecttest.util.extentions.launchMainToLoginSignUpActivity
import com.ogungor.tabprojecttest.util.extentions.showShortToast

class MainActivity : BaseActivity(), MainActivityContract.View {
    private lateinit var mainActivityPresenter: MainActivityContract.Presenter
    private lateinit var ImageButtonFeed:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityPresenter = MainActivityPresenter().apply {
            setView(this@MainActivity)
            create()
        }
    }

    override fun getLayout(): Int = R.layout.activity_main


    override fun initUi() {
        ImageButtonFeed=findViewById(R.id.feed_button)
    }

    override fun showSignOutMessage() {
        showShortToast(getString(R.string.log_out))
    }

    override fun intentToLoginSignUpActivity() {
        launchMainToLoginSignUpActivity()
        finish()
    }

    fun feedActivity(view: View){
        launchMainToFeedsActivity()
    }

    fun logOutUser(view: View){
        mainActivityPresenter.logOutUser()
    }
}