package com.ogungor.tabprojecttest.main

import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.ogungor.tabprojecttest.R

class MainActivityPresenter : MainActivityContract.Presenter {

    private var view:MainActivityContract.View?=null
    private var auth: FirebaseAuth? = null

    override fun create() {
        auth= FirebaseAuth.getInstance()
        view?.apply {
            initUi()
        }
    }

    override fun setView(view: MainActivityContract.View) {
        this.view=view
    }

    override fun destroy() {
        view=null
        auth=null
    }


    override fun menuItemSelected(item: MenuItem) {
        if (item.itemId == R.id.logout) {
            auth?.signOut()
            view?.run {
                showSignOutMessage()
                intentToLoginSignUpActivity()
            }
        }
    }
}