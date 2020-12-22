package com.ogungor.tabprojecttest.ui.main.loginFragment

import android.content.SharedPreferences

interface LoginUserFragmentContract {

    interface Presenter {

        fun createView()

        fun setView(view: LoginUserFragmentContract.View)

        fun destroy()

        fun loginUserListener(
            toString: String,
            toString1: String,
            boolean: Boolean,
            sharedPref: SharedPreferences?
        )

        fun loginUser(email: String, password: String)

        fun handlerError(exp: Exception)

    }


    interface View {

        fun initUi()

        fun initClickListener()

        fun showEmptyAreaMessage()

        fun intentToFeedsActivity()

        fun showCreateUserSuccessfulMessage()

        fun showInvalidEmailMessage()

        fun showInvalidPasswordMessage()

        fun showLoginUserFailureMessage()
    }
}