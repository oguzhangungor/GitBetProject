package com.ogungor.tabprojecttest.main

import android.view.MenuItem

interface MainActivityContract {

    interface Presenter {

        fun create()

        fun setView( view: View)

        fun destroy()

        fun logOutUser()

    }


    interface View {

        fun initUi()

        fun showSignOutMessage()

        fun intentToLoginSignUpActivity()

    }
}