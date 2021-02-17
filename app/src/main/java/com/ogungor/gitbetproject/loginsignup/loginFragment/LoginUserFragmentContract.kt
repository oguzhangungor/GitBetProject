package com.ogungor.gitbetproject.loginsignup.loginFragment

import android.content.SharedPreferences
import android.widget.CheckBox

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

        fun checkBoxControl(rememberCheckBox: CheckBox): Boolean



    }


    interface View {

        fun initUi()

        fun initClickListener()

        fun showEmptyAreaMessage()

        fun intentToMainsActivity()

        fun showCreateUserSuccessfulMessage()

        fun showInvalidEmailMessage()

        fun showInvalidPasswordMessage()

        fun showLoginUserFailureMessage()

    }
}