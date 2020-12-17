package com.ogungor.tabprojecttest.ui.main

import com.google.firebase.auth.FirebaseAuth

class MainActivityPresenter : MainActivityContract.Presenter{
    private var view: MainActivityContract.View?=null


    override fun create() {
        view?.apply {
            initUi()
        }
    }

    override fun setView(view: MainActivityContract.View) {
        this.view=view
    }

    override fun destroy() {
        view=null
    }

    override fun loginUserControl(currentUser: FirebaseAuth?) {
        view?.run {
           showLoginMessage()
        }
        if (currentUser != null){
            view?.run {
                intentToFeedsActivity()


            }
        }
    }
}