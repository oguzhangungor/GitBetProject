package com.ogungor.tabprojecttest.ui.main

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

interface MainActivityContract {

    interface Presenter {

        fun create ( )

        fun setView(view: MainActivityContract.View)

        fun destroy()

        fun loginUserControl(currentUser: FirebaseUser?)
    }


    interface View {

        fun initUi()

        fun intentToFeedsActivity()

        fun showLoginMessage()
    }
}